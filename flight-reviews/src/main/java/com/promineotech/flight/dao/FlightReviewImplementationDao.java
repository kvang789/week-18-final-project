package com.promineotech.flight.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.promineotech.flight.dao.FlightImplementationDao.SqlParams;
import com.promineotech.flight.entity.FlightReview;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FlightReviewImplementationDao implements FlightReviewInterfaceDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	//GET
	@Override
	public List<FlightReview> fetchReviews(int flightReviewId) {
		log.info("DAO: flightReviewId= {}");

		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM flight_reviews "
				+ "WHERE flight_review_id = :flight_review_id";
		// @formatter:on

		Map<String, Object> params = new HashMap<>();
		params.put("flight_review_id", flightReviewId);
		log.info("This is the sql= {}", sql);
		log.info("This is the params= {}", params);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			@Override
			public FlightReview mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				log.info("This rs.getInt= {}", rs.getInt("flight_review_id"));
				// @formatter:off
				return FlightReview.builder()
						.flightReviewId(rs.getInt("flight_review_id"))
						.flightId(rs.getInt("flight_id"))
						.passengerId(rs.getInt("passenger_id"))
						.wasOnTime(rs.getBoolean("was_on_time"))
						.seatWasClean(rs.getBoolean("seat_was_clean"))
						.build();
				// @formatter:on

			}});
	}

}
