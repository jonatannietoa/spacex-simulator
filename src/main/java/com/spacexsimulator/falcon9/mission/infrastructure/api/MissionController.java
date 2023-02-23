package com.spacexsimulator.falcon9.mission.infrastructure.api;

import com.spacexsimulator.falcon9.mission.application.MissionService;
import com.spacexsimulator.falcon9.mission.application.commandmodel.MissionCommandModelOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MissionController {

    private MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping("/api/mission/start-mission")
    ResponseEntity<MissionCommandModelOutput> startMission() {
        return new ResponseEntity<>(missionService.start(), HttpStatus.OK);
    }
}
