package com.promineotech.flight.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Flight {
	private int flightId;
	private int passengerId;
	private String airlineName;
	private String departureAirportCode;
	private LocalDate departureDate;


	
}
