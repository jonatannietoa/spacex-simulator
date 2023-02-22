package com.spacexsimulator.falcon9.mission.infrastructure.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MissionController {
    @GetMapping("/api/mission/start-mission")
    String startMission() {
        return "Mission Started";
    }
}
