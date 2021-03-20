package com.springbootindustry.microservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IndustryServiceConfig {

	@Value("${acotrs.microservice.url}")
	private String actorServiceUrl;

	public String getActorServiceUrl() {
		return actorServiceUrl;
	}

	public void setActorServiceUrl(String actorServiceUrl) {
		this.actorServiceUrl = actorServiceUrl;
	}

}
