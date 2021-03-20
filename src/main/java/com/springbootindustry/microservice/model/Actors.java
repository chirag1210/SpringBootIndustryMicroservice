package com.springbootindustry.microservice.model;

public class Actors{
	private String starName;
	private String description;
	
	
	public Actors(String starName, String description) {
		super();
		this.starName = starName;
		this.description = description;
	}


	public String getStarName() {
		return starName;
	}


	public void setStarName(String starName) {
		this.starName = starName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}