package com.promineotech.flight.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.flight.dao.PassengerImplementationDao;
import com.promineotech.flight.entity.Passenger;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PassengerImplementationService implements PassengerInterfaceService {
	
	@Autowired
	private PassengerImplementationDao passengerImplementationDao;
	
	@Transactional
	@Override
	public Passenger createPassenger(String firstName, String lastName) {
		return passengerImplementationDao.createPassenger(firstName, lastName);
	}

	@Override
	public List<Passenger> fetchPassengers(String firstName, String lastName) {
		
		List<Passenger> passengers = passengerImplementationDao.fetchPassengers(firstName, lastName);
		
		if(passengers.isEmpty()) {
			String msg = String.format("No passenger found with firstName=%s and lastName=%s\", firstName, lastName");
			throw new NoSuchElementException(msg);
		}
		
		return passengers;
	}

	@Override
	public void deletePassenger(int passengerId) {
		log.info("The deletePassenger method was called with passengerId={}, passengerid");
		passengerImplementationDao.deletePassenger(passengerId);
		
	}

	@Override
	public Passenger updatePassenger(int passengerId, String firstName, String lastName) {
		return passengerImplementationDao.updatePassenger(passengerId, firstName, lastName);
	}

}
