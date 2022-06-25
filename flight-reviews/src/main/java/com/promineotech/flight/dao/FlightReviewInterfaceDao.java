package com.promineotech.flight.dao;

import java.util.List;

import com.promineotech.flight.entity.FlightReview;


public interface FlightReviewInterfaceDao {

	List<FlightReview> fetchReviews(int flightReviewId);

}
