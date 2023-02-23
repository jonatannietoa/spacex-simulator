package com.spacexsimulator.falcon9.mission.domain;

import com.spacexsimulator.falcon9.coldgasthrusters.domain.ColdGasThrusters;
import com.spacexsimulator.falcon9.engine.domain.Engine;
import com.spacexsimulator.falcon9.gimbal.domain.Gimbal;
import com.spacexsimulator.falcon9.gps.domain.GPS;
import com.spacexsimulator.falcon9.gridfins.domain.GridFins;
import com.spacexsimulator.falcon9.kerosene.domain.Kerosene;
import com.spacexsimulator.falcon9.landinglegs.domain.LandingLegs;
import com.spacexsimulator.falcon9.lox.domain.LOX;
import com.spacexsimulator.falcon9.secondstage.domain.SecondStage;
import com.spacexsimulator.falcon9.turbopump.domain.TurboPump;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Falcon9ActualStats {
  private ColdGasThrusters coldGasThrusters;
  private Engine engine;
  private Gimbal gimbal;
  private GPS gps;
  private GridFins gridFins;
  private Kerosene kerosene;
  private LandingLegs landingLegs;
  private LOX lox;
  private SecondStage secondStage;
  private TurboPump turboPump;
}
