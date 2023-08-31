package com.airport;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.airport.Model.AirportComments;
import com.airport.Model.Airports;
import com.airport.serviceImpl.AirportCommentsServiceImpl;
import com.airport.serviceImpl.AirportServiceImpl;
import com.airport.services.AirportCommentsService;

@SpringBootTest
class AirportCaseStudyApplicationTests {

	@Autowired
	private AirportServiceImpl service;
	
	Logger logger = LoggerFactory.getLogger(AirportCaseStudyApplicationTests.class);
	
	
	@Test
	public void testGetAllAirports() {
		List<Airports> airports = service.getAirports();
		
		logger.info(airports.toString());
		Assertions.assertNotNull(airports);
	}
	

}
