package com.spacexsimulator.falcon9.mission.application.services;

import com.spacexsimulator.falcon9.mission.application.exceptions.CheckException;
import com.spacexsimulator.falcon9.mission.domain.Falcon9ActualStats;

public interface MissionService {
  Falcon9ActualStats check() throws CheckException;
}
