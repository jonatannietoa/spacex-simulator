package com.spacexsimulator.falcon9.mission.application.statesmachine;

import com.spacexsimulator.falcon9.mission.application.statesservices.falcon9.*;
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
                    .state(MissionStates.CHECK, new Check(), null)
                    .states(EnumSet.allOf(MissionStates.class))
        ;
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<MissionStates, MissionEvents> transitions) throws Exception {
        // STATE MACHINE TRANSITIONS
        transitions
                .withExternal()
                    .source(MissionStates.CHECK).target(MissionStates.LAUNCH).event(MissionEvents.SUCCESS).action(new Launch())
                    .and()
                .withExternal()
                    .source(MissionStates.CHECK).target(MissionStates.STOP).event(MissionEvents.FAILURE).action(new Stop())
                    .and()
                .withExternal()
                    .source(MissionStates.LAUNCH).target(MissionStates.ASCENT).event(MissionEvents.SUCCESS).action(new Ascent())
                    .and()
                .withExternal()
                    .source(MissionStates.ASCENT).target(MissionStates.STAGE_SEPARATION).event(MissionEvents.SUCCESS).action(new StageSeparation())
                    .and()
                .withExternal()
                    .source(MissionStates.STAGE_SEPARATION).target(MissionStates.FLIP_MANEUVER).event(MissionEvents.SUCCESS).action(new FlipManeuver())
                    .and()
                .withExternal()
                    .source(MissionStates.FLIP_MANEUVER).target(MissionStates.BOOST_BACK_BURN).event(MissionEvents.SUCCESS).action(new BoostBackBurn())
                    .and()
                .withExternal()
                    .source(MissionStates.BOOST_BACK_BURN).target(MissionStates.GRID_FINS_DEPLOY).event(MissionEvents.SUCCESS).action(new GridFinsDeploy())
                    .and()
                .withExternal()
                    .source(MissionStates.GRID_FINS_DEPLOY).target(MissionStates.ENTRY_BURN).event(MissionEvents.SUCCESS).action(new EntryBurn())
                    .and()
                .withExternal()
                    .source(MissionStates.ENTRY_BURN).target(MissionStates.AERODYNAMIC_GUIDANCE).event(MissionEvents.SUCCESS).action(new AerodynamicGuidance())
                    .and()
                .withExternal()
                    .source(MissionStates.AERODYNAMIC_GUIDANCE).target(MissionStates.VERTICAL_LANDING).event(MissionEvents.SUCCESS).action(new VerticalLanding())
                    .and()
                .withExternal()
                    .source(MissionStates.VERTICAL_LANDING).target(MissionStates.LANDED_CHECKS).event(MissionEvents.SUCCESS).action(new Landed())
                    .and()
                .withExternal()
                    .source(MissionStates.LANDED_CHECKS).target(MissionStates.FAIRING_SEPARATION).event(MissionEvents.SUCCESS).action(new FairingSeparation())
                    .and()
                .withExternal()
                    .source(MissionStates.FAIRING_SEPARATION).target(MissionStates.PAYLOAD_SEPARATION).event(MissionEvents.SUCCESS).action(new PayloadSeparation());
    }

}
