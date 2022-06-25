package com.promineotech.flight.dao;

import java.util.List;

import com.promineotech.flight.entity.Passenger;

public interface PassengerInterfaceDao {
	
	
	Passenger createPassenger(String firstName, String lastName);
	
	Passenger savePassenger(String firstName, String lastName);
	
	List<Passenger> fetchPassengers(String firstName, String lastName);
	
	void deletePassenger(int passengerId);
	
	Passenger updatePassenger(int passengerId, String firstName, String lastName);

}
