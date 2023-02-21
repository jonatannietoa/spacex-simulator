package com.spacexsimulator.falcon9.kerosene.domain;

import com.spacexsimulator.falcon9.turbopump.domain.TurboPump;
import jdk.jfr.Percentage;

public class KeroseneControl {
    private boolean mainValve;
    private Integer fuelRatio;

    private Percentage fuelPumpPercentage;

    // 801 kg/s at 100%
    private Double flowRate;
    private TurboPump turbopump;
}
