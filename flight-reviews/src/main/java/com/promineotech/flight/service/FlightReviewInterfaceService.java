package com.promineotech.flight.service;

import java.util.List;

import com.promineotech.flight.entity.FlightReview;

public interface FlightReviewInterfaceService {

	List<FlightReview> fetchFlightReviews(int flightReviewId);

}
