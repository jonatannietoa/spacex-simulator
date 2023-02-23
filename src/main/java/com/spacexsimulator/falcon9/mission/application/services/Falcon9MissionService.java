package com.spacexsimulator.falcon9.mission.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spacexsimulator.falcon9.coldgasthrusters.application.ColdGasThrustersService;
import com.spacexsimulator.falcon9.coldgasthrusters.domain.ColdGasThrusters;
import com.spacexsimulator.falcon9.mission.application.exceptions.CheckException;
import com.spacexsimulator.falcon9.mission.domain.Falcon9ActualStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Falcon9MissionService implements MissionService {

  private Falcon9ActualStats falcon9ActualStatsSingleton;
  private ColdGasThrustersService coldGasThrustersService;
  private ObjectMapper objectMapper;

  @Autowired
  public Falcon9MissionService(
      Falcon9ActualStats falcon9ActualStatsSingleton,
      ColdGasThrustersService coldGasThrustersService,
      ObjectMapper objectMapper) {
    this.falcon9ActualStatsSingleton = falcon9ActualStatsSingleton;
    this.coldGasThrustersService = coldGasThrustersService;
    this.objectMapper = objectMapper;
  }

  @Override
  public Falcon9ActualStats check() throws CheckException {
    try {
      falcon9ActualStatsSingleton.setColdGasThrusters(
          objectMapper.convertValue(coldGasThrustersService.check(), ColdGasThrusters.class));

      return falcon9ActualStatsSingleton;
    } catch (Exception e) {
      throw new CheckException();
    }
  }
}
