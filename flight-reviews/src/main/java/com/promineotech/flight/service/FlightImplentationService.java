package com.promineotech.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.flight.dao.FlightImplementationDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FlightImplentationService implements FlightInterfaceService {
	
	@Autowired
	private FlightImplementationDao flightImplementation;
	
	@Transactional
	@Override
	public void deleteFlight(int flightId) {
		log.info("The deleteFlightmethod was called with flightId={}, flightid");
		flightImplementation.deleteFlight(flightId);
	}
}
