package com.spacexsimulator.falcon9.coldgasthrusters.application.port;

import com.spacexsimulator.falcon9.coldgasthrusters.application.commandmodel.ColdGasThrustersCommandModelOutput;
import com.spacexsimulator.falcon9.coldgasthrusters.domain.exceptions.ColdGasThrustersException;
import com.spacexsimulator.falcon9.mission.domain.Falcon9ActualStats;

public interface ColdGasThrustersApi {
  ColdGasThrustersCommandModelOutput getColdGasThrusters(String uri)
          throws ColdGasThrustersException;

  ColdGasThrustersCommandModelOutput postColdGasThrusters(Falcon9ActualStats falcon9ActualStats, String uri)
      throws ColdGasThrustersException;

}
