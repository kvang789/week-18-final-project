package com.promineotech.flight.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


//@Service
@Component
@Slf4j
public class FlightImplementationDao implements FlightInterfaceDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	//DELETE

	@Override
	public void deleteFlight(int flightId) {
		SqlParams params = generateDeleteFlightSql(flightId);

		jdbcTemplate.update(params.sql, params.source);

		//return null;

	}

	// THIS SECTION IS FOR SQL
	private SqlParams generateDeleteFlightSql(int flightId) {
		SqlParams params = new SqlParams();
		// @formatter:off
		params.sql = ""
				+ "DELETE FROM flights "
				+ "WHERE flight_id = :flight_id ";
		// @formatter:on		
		params.source.addValue("flight_id", flightId);

		log.info("This is the generateDeletePassengerSql= {}", params.sql);
		return params;	
	}

	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
}