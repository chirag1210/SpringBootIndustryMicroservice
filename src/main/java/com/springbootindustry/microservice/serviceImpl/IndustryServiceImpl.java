package com.springbootindustry.microservice.serviceImpl;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootindustry.microservice.config.IndustryServiceConfig;
import com.springbootindustry.microservice.model.Actors;
import com.springbootindustry.microservice.model.IndustryResponse;
import com.springbootindustry.microservice.service.IndustryService;
import static java.text.MessageFormat.format;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndustryServiceImpl implements IndustryService {

	@Autowired
	IndustryServiceConfig industryServiceConfig;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ObjectMapper mapper;
	
	@SuppressWarnings("unchecked")
	@Override
	public IndustryResponse getActorsByIndustryName(String industryName) {

		String Url = getActorsServiceApiURL(industryName);

		ResponseEntity<Object> restResponse = null;
		List<Actors> actorsResponse = null;
		IndustryResponse industryResponse = new IndustryResponse();
		
		restResponse = restTemplate.getForEntity(Url, Object.class);
		
		actorsResponse = mapper.convertValue(restResponse.getBody(), ArrayList.class);
		
		industryResponse.setIndustryName(industryName);
		industryResponse.setActorsList(actorsResponse);
		
		return industryResponse;
	}


	private String getActorsServiceApiURL(String industryName) {
		UriComponentsBuilder uriBuilder = null;

		if (!Strings.isBlank(industryName)) {
			uriBuilder = UriComponentsBuilder.fromUriString(format(industryServiceConfig.getActorServiceUrl(), industryName));
		}

		return uriBuilder.build().encode().toUriString();

	}
}
