package com.springbootindustry.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootindustry.microservice.model.IndustryResponse;
import com.springbootindustry.microservice.service.IndustryService;
import com.springbootindustry.microservice.serviceImpl.IndustryServiceImpl;

@RestController
public class IndustryController {

	@Autowired
	IndustryServiceImpl industryService;

	@GetMapping(value = "/getActorsByIndustryName/{industryName}")
	public ResponseEntity<IndustryResponse> getActorsByIndustryName(String industryName) {

		IndustryResponse industryResponse = industryService.getActorsByIndustryName(industryName);
		return new ResponseEntity<>(industryResponse, HttpStatus.OK);
	}

}
