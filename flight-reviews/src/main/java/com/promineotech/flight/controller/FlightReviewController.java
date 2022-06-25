package com.promineotech.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.flight.entity.FlightReview;
import com.promineotech.flight.service.FlightReviewInterfaceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FlightReviewController implements FlightReviewInterfaceController {
	
	@Autowired
	private FlightReviewInterfaceService flightReviewService;
	
	@Override
	public List<FlightReview> fetchFlightReviews(int flightReviewId) {
		log.info("The method fetchFlightReviews was called with flightReviewId= {}", flightReviewId);
		return flightReviewService.fetchFlightReviews(flightReviewId);
	}
}
