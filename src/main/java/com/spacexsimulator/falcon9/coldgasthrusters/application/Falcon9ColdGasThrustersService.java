package com.spacexsimulator.falcon9.coldgasthrusters.application;

import com.spacexsimulator.falcon9.coldgasthrusters.application.commandmodel.ColdGasThrustersCommandModelOutput;
import com.spacexsimulator.falcon9.coldgasthrusters.application.port.ColdGasThrustersApi;
import com.spacexsimulator.falcon9.coldgasthrusters.domain.exceptions.ColdGasThrustersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Falcon9ColdGasThrustersService implements ColdGasThrustersService {

  private final ColdGasThrustersApi coldGasThrustersApi;

  @Autowired
  public Falcon9ColdGasThrustersService(ColdGasThrustersApi coldGasThrustersApi) {
    this.coldGasThrustersApi = coldGasThrustersApi;
  }

  @Override
  public ColdGasThrustersCommandModelOutput check() throws ColdGasThrustersException {
    return coldGasThrustersApi.getColdGasThrusters("/check");
  }
}
