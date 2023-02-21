package com.spacexsimulator.falcon9.gridfins.domain;

import com.spacexsimulator.falcon9.gimbal.domain.exceptions.WrongDegreesValueException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FinDegree {
    private int value;

    public void setValue(int value) throws WrongDegreesValueException {
        if (value <= -20 || value >= 20)
            throw new WrongDegreesValueException("Degrees must be between 0 or 20");

        this.value = value;
    }
}
