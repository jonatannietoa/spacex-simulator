package com.spacexsimulator.falcon9.engine.domain;

import com.spacexsimulator.falcon9.gimbal.domain.Gimbal;
import jdk.jfr.Percentage;

public class Engine {
    private Percentage throttle;
    private Mode mode;
    private Integer chamberPressure;
}
