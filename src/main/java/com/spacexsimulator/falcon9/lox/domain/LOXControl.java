package com.spacexsimulator.falcon9.lox.domain;

import com.spacexsimulator.falcon9.turbopump.domain.TurboPump;
import jdk.jfr.Percentage;

public class LOXControl {
    private boolean mainValve;
    private Integer loxRatio;
    private Percentage loxPumpPercentage;

    // 1919 kg/s at 100%
    private Double flowRate;

    private TurboPump turbopump;

}
