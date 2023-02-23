package com.spacexsimulator.falcon9.coldgasthrusters.application.commandmodel;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ColdGasThrustersCommandModelOutput {
    private ColdGasThrusterCommandModelOutput right;
    private ColdGasThrusterCommandModelOutput left;
}
