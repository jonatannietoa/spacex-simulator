package com.spacexsimulator.falcon9.mission.application;

import com.spacexsimulator.falcon9.mission.application.commandmodel.MissionCommandModelInput;
import com.spacexsimulator.falcon9.mission.application.commandmodel.MissionCommandModelOutput;
import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionEvents;
import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

@Service("starlink-mission")
public class StarlinkMissionService implements MissionService {

    private StateMachine<MissionStates, MissionEvents> stateMachine;

    @Autowired
    public StarlinkMissionService(StateMachine<MissionStates, MissionEvents> stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public MissionCommandModelOutput start() {
        stateMachine.stopReactively().subscribe();
        stateMachine.startReactively().subscribe();

        return new MissionCommandModelOutput("Starlink Mission started.");
    }
}
