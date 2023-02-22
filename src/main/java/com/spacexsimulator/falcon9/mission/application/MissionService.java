package com.spacexsimulator.falcon9.mission.application;

import com.spacexsimulator.falcon9.mission.application.commandmodel.MissionCommandModelInput;
import com.spacexsimulator.falcon9.mission.application.commandmodel.MissionCommandModelOutput;

public interface MissionService {

    MissionCommandModelOutput start();
}
