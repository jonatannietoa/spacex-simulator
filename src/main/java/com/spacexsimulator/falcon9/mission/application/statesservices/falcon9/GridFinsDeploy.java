package com.spacexsimulator.falcon9.mission.application.statesservices.falcon9;

import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionEvents;
import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionStates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import reactor.core.publisher.Mono;

public class GridFinsDeploy implements Action<MissionStates, MissionEvents> {
  Logger logger = LoggerFactory.getLogger(GridFinsDeploy.class);

  @Override
  public void execute(StateContext<MissionStates, MissionEvents> context) {
    logger.info("** Falcon 9 ** Deploying Grid Fins");

    Message<MissionEvents> event = MessageBuilder.withPayload(MissionEvents.SUCCESS).build();
    context.getStateMachine().sendEvent(Mono.just(event)).subscribe();
  }
}
