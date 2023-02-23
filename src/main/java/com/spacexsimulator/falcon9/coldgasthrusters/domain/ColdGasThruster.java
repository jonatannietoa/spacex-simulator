package com.spacexsimulator.falcon9.coldgasthrusters.domain;

import jdk.jfr.Percentage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ColdGasThruster {
    private Percentage thrust;
    private Integer secondsOfThrust;
}
