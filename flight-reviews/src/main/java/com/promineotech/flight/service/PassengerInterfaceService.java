package com.promineotech.flight.service;

import java.util.List;

import com.promineotech.flight.entity.Passenger;

public interface PassengerInterfaceService {

	Passenger createPassenger(String firstName, String lastName);
	
	List<Passenger> fetchPassengers(String firstName, String lastName);
	
	void deletePassenger(int passengerId);
	
	Passenger updatePassenger(int passengerId, String firstName, String lastName);
	
	
	
	
}
