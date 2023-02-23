package com.spacexsimulator.falcon9.coldgasthrusters.application.commandmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ColdGasThrusterCommandModelOutput {
  private Double thrust;
  private Integer secondsOfThrust;
}
