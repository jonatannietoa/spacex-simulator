package com.spacexsimulator.falcon9.mission.application;

import com.spacexsimulator.falcon9.mission.application.commandmodel.MissionCommandModelInput;
import com.spacexsimulator.falcon9.mission.application.commandmodel.MissionCommandModelOutput;
import org.springframework.stereotype.Service;

@Service("starlink-mission")
public class StarlinkMissionService implements MissionService {
    @Override
    public MissionCommandModelOutput checkFalcon9(MissionCommandModelInput missionCommandModelInput) {
        return null;
    }
}
