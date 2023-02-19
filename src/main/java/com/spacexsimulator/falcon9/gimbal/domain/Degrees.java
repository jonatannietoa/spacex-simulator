package com.spacexsimulator.falcon9.gimbal.domain;

import com.spacexsimulator.falcon9.gimbal.domain.exceptions.WrongDegreesValueException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Degrees {
    private int value;

    public void setValue(int value) throws WrongDegreesValueException {
        if (value < 0 || value > 360)
            throw new WrongDegreesValueException("Degrees must be between 0 or 360");

        this.value = value;
    }
}
