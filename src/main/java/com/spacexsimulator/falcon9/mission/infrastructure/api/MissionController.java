package com.spacexsimulator.falcon9.mission.infrastructure.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MissionController {

    String startMission() {

        return "Mission Started";
    }
}
