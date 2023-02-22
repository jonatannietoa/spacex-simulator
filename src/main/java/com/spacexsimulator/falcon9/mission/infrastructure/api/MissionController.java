package com.spacexsimulator.falcon9.mission.infrastructure.api;

import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionEvents;
import com.spacexsimulator.falcon9.mission.application.statesmachine.MissionStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MissionController {

    private StateMachine<MissionStates, MissionEvents> stateMachine;

    @Autowired
    public MissionController(StateMachine<MissionStates, MissionEvents> stateMachine) {
        this.stateMachine = stateMachine;
    }

    @GetMapping("/api/mission/start-mission")
    String startMission() {
        stateMachine.startReactively().subscribe();

        return "Mission Started";
    }
}
