package com.promineotech.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.flight.dao.FlightReviewImplementationDao;
import com.promineotech.flight.entity.FlightReview;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FlightReviewImplementationService implements FlightReviewInterfaceService {
	
	@Autowired
	private FlightReviewImplementationDao flightReviewImplementtationDao;

	@Transactional	
	@Override
	public List<FlightReview> fetchFlightReviews(int flightReviewId) {
		
		List<FlightReview> flightReviews = flightReviewImplementtationDao.fetchReviews(flightReviewId);
		return flightReviews;
	}

	}


