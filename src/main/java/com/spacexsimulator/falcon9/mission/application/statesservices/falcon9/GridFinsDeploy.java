package com.spacexsimulator.falcon9.mission.application.statesservices.falcon9;


import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionEvents;
import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionStates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public class GridFinsDeploy implements Action<MissionStates, MissionEvents> {
    Logger logger = LoggerFactory.getLogger(GridFinsDeploy.class);

    @Override
    public void execute(StateContext<MissionStates, MissionEvents> context) {
        logger.info("** Falcon 9 ** Engines to boosting back mode");
        context.getStateMachine().sendEvent(MissionEvents.SUCCESS);
    }
}
