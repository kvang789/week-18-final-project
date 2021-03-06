package com.promineotech.flight.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.flight.entity.Passenger;

import lombok.extern.slf4j.Slf4j;


//This class will create, get(fetch), delete, and update the passenger class

//@Service
@Component
@Slf4j
public class PassengerImplementationDao implements PassengerInterfaceDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	//POST
	@Override
	public Passenger createPassenger(String firstName, String lastName) {
		SqlParams params = generateCreateSql(firstName, lastName);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(params.sql, params.source, keyHolder);

		savePassenger(firstName, lastName);

		return Passenger.builder()
				.firstName(firstName)
				.lastName(lastName)
				.build();
	}

	@Override
	public Passenger savePassenger(String firstName, String lastName) {
		return null;
		// part of line 36
	}

	//GET
	@Override
	public List<Passenger> fetchPassengers(String firstName, String lastName) {
		log.info("DAO: firstName={}, lastName={}, firstName, lastName");

		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM passengers "
				+ "WHERE first_name = :first_name AND last_name = :last_name";
		// @formatter:on

		Map<String, Object> params = new HashMap<>();
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		log.info("This is the sql={}", sql);
		log.info("This is the params={}", params);

		return jdbcTemplate.query(sql, params, new RowMapper<>() {		
			@Override
			public Passenger mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Passenger.builder()
						.passengerId(rs.getInt("passenger_id"))
						.firstName(rs.getString("first_name"))
						.lastName(rs.getString("last_name"))
						.build();
				// @formatter:on
			}});
	}

	//DELETE
	@Override
	public void deletePassenger(int passengerId) {
		SqlParams params = generateDeletePassengerSql(passengerId);

		jdbcTemplate.update(params.sql, params.source);

		//return null;

	}

	@Override
	public Passenger updatePassenger(int passengerId, String firstName, String lastName) {
		SqlParams params = generateUpdatePassengerSql(passengerId, firstName, lastName);

		jdbcTemplate.update(params.sql, params.source);
		// @formatter:off
		return Passenger.builder()
				.passengerId(passengerId)
				.firstName(firstName)
				.lastName(lastName)
				.build();
		// @formatter:on

	}

	// THIS SECTION IS FOR SQL

	private SqlParams generateInsertSql(String firstName, String lastName) {
		SqlParams params = new SqlParams();
		// @formatter:off
		params.sql = ""
				+ "INSERT INTO passengers "
				+ "first_name, last_name"
				+ ") VALUES ("
				+ ":first_name, :last_name"
				+ ")";
		// @formatter:on
		params.source.addValue("first_name", firstName);
		params.source.addValue("last_name", lastName);

		log.info("This is the generateInsertSql= {}", params.sql);
		return params;

	}

	private SqlParams generateUpdatePassengerSql(int passengerId, String firstName, String lastName) {
		SqlParams params = new SqlParams();

		// @formatter:off
		params.sql = ""
				+ "UPDATE passengers "
				+ " SET "
				+ "first_name = :first_name "
				+ ", last_name = :last_name "
				+ "WHERE passenger_id = :passenger_id";
		// formatter:off

		params.source.addValue("passenger_id", passengerId);
		params.source.addValue("first_name", firstName);
		params.source.addValue("last_name", lastName);

		log.info("This is the generateUpdatePassengerSql= {}", params.sql);
		return params;

	}

	private SqlParams generateDeletePassengerSql(int passengerId) {
		SqlParams params = new SqlParams();
		// @formatter:off
		params.sql = ""
				+ "DELETE FROM passengers "
				+ "WHERE passenger_id = :passenger_id ";
		// @formatter:on		
		params.source.addValue("passenger_id", passengerId);

		log.info("This is the generateDeletePassengerSql= {}", params.sql);
		return params;

	}

	private SqlParams generateCreateSql(String firstName, String lastName) {
		SqlParams params = new SqlParams();

		// @formatter:off
		params.sql = ""
				+ "INSERT INTO passengers ("
				+ "first_name, last_name"
				+ ") VALUES ("
				+ ":first_name, :last_name"
				+ ")";
		// @formatter:on

		params.source.addValue("first_name", firstName);
		params.source.addValue("last_name", lastName);

		log.info("This is the generateCreateSql= {}", params.sql);
		return params;
	}

	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}
}