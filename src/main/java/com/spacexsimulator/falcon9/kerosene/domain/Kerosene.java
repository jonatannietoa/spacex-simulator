package com.spacexsimulator.falcon9.kerosene.domain;

import com.spacexsimulator.falcon9.turbopump.domain.TurboPump;
import jdk.jfr.Percentage;

public class Kerosene {
    private boolean mainValve;
    private Integer ratio;
    private Percentage fuelPumpPercentage;
    // 801 kg/s at 100%
    private Double flowRate;
}