package com.spacexsimulator.falcon9.coldgasthrusters.infrastructure.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spacexsimulator.falcon9.coldgasthrusters.application.commandmodel.ColdGasThrustersCommandModelOutput;
import com.spacexsimulator.falcon9.coldgasthrusters.application.port.ColdGasThrustersApi;
import com.spacexsimulator.falcon9.coldgasthrusters.domain.exceptions.ColdGasThrustersException;
import com.spacexsimulator.falcon9.mission.domain.Falcon9ActualStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class Falcon9ColdGasThrustersApi implements ColdGasThrustersApi {
  private final Environment env;

  private final ObjectMapper objectMapper;

  private final WebClient webClient;

  @Autowired
  public Falcon9ColdGasThrustersApi(
      Environment env, WebClient webClient, ObjectMapper objectMapper) {
    this.env = env;
    this.objectMapper = objectMapper;
    this.webClient = webClient;
  }

  @Override
  public ColdGasThrustersCommandModelOutput getColdGasThrusters(String uri)
      throws ColdGasThrustersException {
    String requestURI = this.env.getProperty("spacex.falcon9.coldgasthrusters.api") + uri;
    try {
      Object response =
          webClient
              .get()
              .uri(requestURI)
              .accept(MediaType.APPLICATION_JSON)
              .retrieve()
              .bodyToMono(Object.class)
              .log()
              .block();
      return objectMapper.convertValue(response, ColdGasThrustersCommandModelOutput.class);
    } catch (Exception e) {
      throw new ColdGasThrustersException(e.getMessage());
    }
  }

  @Override
  public ColdGasThrustersCommandModelOutput postColdGasThrusters(
      Falcon9ActualStats falcon9ActualStats, String uri) throws ColdGasThrustersException {
    String requestURI = this.env.getProperty("spacex.falcon9.coldgasthrusters.api") + uri;
    try {
      Object response =
          webClient
              .post()
              .uri(requestURI)
              .contentType(MediaType.APPLICATION_JSON)
              .bodyValue(falcon9ActualStats)
              .accept(MediaType.APPLICATION_JSON)
              .retrieve()
              .bodyToMono(Object.class)
              .log()
              .block();
      return objectMapper.convertValue(response, ColdGasThrustersCommandModelOutput.class);
    } catch (Exception e) {
      throw new ColdGasThrustersException(e.getMessage());
    }
  }
}
