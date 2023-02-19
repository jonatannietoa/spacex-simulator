package com.spacexsimulator.falcon9.mission.application.statesservices;

import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionEvents;
import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionStates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public class StopFalcon9 implements Action<MissionStates, MissionEvents> {

    Logger logger = LoggerFactory.getLogger(StopFalcon9.class);

    @Override
    public void execute(StateContext<MissionStates, MissionEvents> context) {
        logger.info("Stopping Falcon 9");
    }
}
