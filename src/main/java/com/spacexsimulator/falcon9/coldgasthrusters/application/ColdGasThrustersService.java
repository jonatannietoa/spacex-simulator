package com.spacexsimulator.falcon9.coldgasthrusters.application;

import com.spacexsimulator.falcon9.coldgasthrusters.application.commandmodel.ColdGasThrustersCommandModelOutput;
import com.spacexsimulator.falcon9.coldgasthrusters.domain.exceptions.ColdGasThrustersException;

public interface ColdGasThrustersService {
  ColdGasThrustersCommandModelOutput check() throws ColdGasThrustersException;
}
