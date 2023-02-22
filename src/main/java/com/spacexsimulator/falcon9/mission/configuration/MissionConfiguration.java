package com.spacexsimulator.falcon9.mission.configuration;

import com.spacexsimulator.falcon9.mission.domain.Falcon9ActualStats;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MissionConfiguration {
    @Bean
    @Scope("singleton")
    public Falcon9ActualStats falcon9ActualStatsSingleton() {
        return new Falcon9ActualStats();
    }
}
