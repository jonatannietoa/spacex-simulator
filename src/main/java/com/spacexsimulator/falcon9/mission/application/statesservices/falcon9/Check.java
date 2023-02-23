package com.spacexsimulator.falcon9.mission.application.statesservices.falcon9;

import com.spacexsimulator.falcon9.mission.application.exceptions.CheckException;
import com.spacexsimulator.falcon9.mission.application.services.MissionService;
import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionEvents;
import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionStates;
import com.spacexsimulator.falcon9.mission.domain.Falcon9ActualStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import reactor.core.publisher.Mono;

public class Check implements Action<MissionStates, MissionEvents> {
    Logger logger = LoggerFactory.getLogger(Check.class);

    private Falcon9ActualStats falcon9ActualStatsSingleton;
    private MissionService checkService;

    public Check(Falcon9ActualStats falcon9ActualStatsSingleton, MissionService checkService) {
        this.falcon9ActualStatsSingleton = falcon9ActualStatsSingleton;
        this.checkService = checkService;
    }

    @Override
    public void execute(StateContext<MissionStates, MissionEvents> context) {
        logger.info("** Falcon 9 ** Checking");
        Message<MissionEvents> event;

        try {
            checkService.check();
            event = MessageBuilder.withPayload(MissionEvents.SUCCESS).build();
        } catch (CheckException e) {
            logger.error("** Falcon 9 ** " + e.getMessage());
            event = MessageBuilder.withPayload(MissionEvents.FAILURE).build();
        }

        context.getStateMachine().sendEvent(Mono.just(event)).subscribe();
    }
}
