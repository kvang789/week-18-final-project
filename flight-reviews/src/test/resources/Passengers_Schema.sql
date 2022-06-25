CREATE DATABASE IF NOT EXISTS passengers;

USE passengers;

DROP TABLE IF EXISTS  flight_ratings;
DROP TABLE IF EXISTS  flights;
DROP TABLE IF EXISTS passengers;

CREATE TABLE passengers (
	passenger_id INT(10) NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(25) NOT NULL,
	last_name VARCHAR(25) NOT NULL,
	PRIMARY KEY (passenger_id)
);

CREATE TABLE flights (
	flight_id INT(10) NOT NULL AUTO_INCREMENT,
	passenger_id INT(10) NOT NULL,
	airline_name VARCHAR(55) NOT NULL,
	departure_airport_code VARCHAR(4) NOT NULL,
	departure_date DATE NOT NULL,
	PRIMARY KEY (flight_id),
	FOREIGN KEY (passenger_id) REFERENCES passengers(passenger_id) ON DELETE CASCADE
);

CREATE TABLE flight_reviews (
	flight_reviews_id INT(10) NOT NULL AUTO_INCREMENT,
	flight_id INT(10) NOT NULL,
	passenger_id INT(10),
	was_on_time BOOLEAN NOT NULL,
	seat_was_clean BOOLEAN NOT NULL,
	PRIMARY KEY (flight_reviews_id),
	FOREIGN KEY (flight_id) REFERENCES flights(flight_id) ON DELETE CASCADE,
	FOREIGN KEY (passenger_id) REFERENCES passengers(passenger_id) ON DELETE CASCADE
);