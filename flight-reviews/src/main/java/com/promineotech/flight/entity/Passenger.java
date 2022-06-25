package com.promineotech.flight.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Passenger {
	private int passengerId;
	private String firstName;
	private String lastName;
	

}
