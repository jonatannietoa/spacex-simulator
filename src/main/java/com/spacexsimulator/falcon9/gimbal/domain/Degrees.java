package com.spacexsimulator.falcon9.gimbal.domain;

import com.spacexsimulator.falcon9.gimbal.domain.exceptions.WrongDegreesValueException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Degrees {
  private Double value;

  public void setValue(Double value) throws WrongDegreesValueException {
    if (value <= 0 || value >= 20)
      throw new WrongDegreesValueException("Gimbal degrees must be between 0 or 20");

    this.value = value;
  }
}
