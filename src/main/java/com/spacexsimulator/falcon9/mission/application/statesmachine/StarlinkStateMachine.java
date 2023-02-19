package com.spacexsimulator.falcon9.mission.application.statesmachine;

import com.spacexsimulator.falcon9.mission.application.MissionService;
import com.spacexsimulator.falcon9.mission.application.statesservices.CheckFalcon9;
import com.spacexsimulator.falcon9.mission.application.statesservices.LaunchFalcon9;
import com.spacexsimulator.falcon9.mission.application.statesservices.StopFalcon9;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

@Configuration
@ComponentScan
@EnableStateMachine
public class StarlinkStateMachine extends EnumStateMachineConfigurerAdapter<MissionStates, MissionEvents> {

    private final MissionService missionService;

    @Autowired
    public StarlinkStateMachine(MissionService missionService) {
        this.missionService = missionService;
    }

    @Bean
    public StateMachineListener<MissionStates, MissionEvents> listener() {
        return new StateMachineListenerAdapter<>() {
            @Override
            public void stateChanged(State<MissionStates, MissionEvents> from, State<MissionStates, MissionEvents> to) {

            }
        };
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<MissionStates, MissionEvents> config) throws Exception {
        // STATE MACHINE CONFIG
        config.withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<MissionStates, MissionEvents> states) throws Exception {
        // STATES OF MACHINE
        states
                .withStates()
                .initial(MissionStates.CHECK)
                .state(MissionStates.CHECK, new CheckFalcon9(), null)
                .states(EnumSet.allOf(MissionStates.class))
        ;

    }

    @Override
    public void configure(StateMachineTransitionConfigurer<MissionStates, MissionEvents> transitions) throws Exception {
        // STATE MACHINE TRANSITIONS
        transitions
                .withExternal()
                    .source(MissionStates.CHECK).target(MissionStates.LAUNCH).event(MissionEvents.SUCCESS).action(new LaunchFalcon9())
                    .and()
                .withExternal()
                    .source(MissionStates.CHECK).target(MissionStates.STOP).event(MissionEvents.FAILURE).action(new StopFalcon9());
    }

}
