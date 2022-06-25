package com.promineotech.flight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.flight.entity.Passenger;
import com.promineotech.flight.service.PassengerInterfaceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PassengerController implements PassengerInterfaceController {
		
	@Autowired
	private PassengerInterfaceService passengerInterfaceService;
	
	@Override
	public List<Passenger> fetchPassengers(String firstName, String lastName) {
		log.info("The fetchPassengers method was called with firstName= {} and lastName= {}", firstName, lastName);
		List<Passenger> results = passengerInterfaceService.fetchPassengers(firstName, lastName);
		log.info("The fetchPassengers method was called and this is the results= {}", results);
		return results;
	}
	@Override
	public Passenger createPassenger(String firstName, String lastName) {
		log.info("The createPassenger method was called with firstName= {} and lastName= {}", firstName, lastName);
		Passenger createResult = passengerInterfaceService.createPassenger(firstName, lastName);
		log.info("The createPassenger method was called with createResult= {}", createResult);
		return createResult;
	}
	
	@Override
	public void deletePassenger(int passengerId) {
		log.info("The method deletePassenger= {}", passengerId);
		passengerInterfaceService.deletePassenger(passengerId);
	}
	
	@Override
	public Passenger updatePassenger(int passengerId, String firstName, String lastName,
			@Valid Passenger updatePassenger) {
		log.info("The method updatePassenger= {}, firstName= {}, lastName= {}", passengerId, firstName, lastName);
		return passengerInterfaceService.updatePassenger(passengerId, firstName, lastName);
	}
	
}
