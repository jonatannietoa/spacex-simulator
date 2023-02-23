package com.spacexsimulator.falcon9.mission.application.statesservices.falcon9;

import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionEvents;
import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionStates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public class Stop implements Action<MissionStates, MissionEvents> {

  Logger logger = LoggerFactory.getLogger(Stop.class);

  @Override
  public void execute(StateContext<MissionStates, MissionEvents> context) {
    logger.error("** Falcon 9 ** Stopping (System Checks Failure)");
  }
}
