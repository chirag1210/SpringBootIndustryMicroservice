package com.springbootindustry.microservice.service;

import com.springbootindustry.microservice.model.IndustryResponse;

public interface IndustryService {

	public IndustryResponse getActorsByIndustryName(String industryName);

}
