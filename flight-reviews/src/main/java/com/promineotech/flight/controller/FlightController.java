package com.promineotech.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.flight.service.FlightInterfaceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FlightController implements FlightInterfaceController {
	
	@Autowired
	private FlightInterfaceService flightInterfaceService;
	
	@Override
	public void deleteFlight(int flightId) {
		log.info("The method deleteFlight= {}", flightId);
		flightInterfaceService.deleteFlight(flightId);
	}

}
