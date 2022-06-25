package com.promineotech.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FlightReview {
	private int flightReviewId;
	private int flightId;
	private int passengerId;
	private Boolean wasOnTime;
	private Boolean seatWasClean;
	
}
