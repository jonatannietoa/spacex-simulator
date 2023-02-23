package com.spacexsimulator.falcon9.mission.application.services;

import com.spacexsimulator.falcon9.mission.application.exceptions.CheckException;
import com.spacexsimulator.falcon9.mission.application.statesservices.falcon9.Check;
import com.spacexsimulator.falcon9.mission.domain.Falcon9ActualStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Falcon9MissionService implements MissionService {

    private Falcon9ActualStats falcon9ActualStatsSingleton;

    public Falcon9MissionService(Falcon9ActualStats falcon9ActualStatsSingleton) {
        this.falcon9ActualStatsSingleton = falcon9ActualStatsSingleton;
    }

    @Override
    public Falcon9ActualStats check() throws CheckException {
        throw new CheckException();
    }
}
