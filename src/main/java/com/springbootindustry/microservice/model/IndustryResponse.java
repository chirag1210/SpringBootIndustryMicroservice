package com.springbootindustry.microservice.model;

import java.util.List;

public class IndustryResponse {

	private String industryName;
	private List<Actors> actorsList;

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public List<Actors> getActorsList() {
		return actorsList;
	}

	public void setActorsList(List<Actors> actorsList) {
		this.actorsList = actorsList;
	}

}
