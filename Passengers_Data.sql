-- Passengers
INSERT INTO passengers (first_name, last_name) VALUES('Bob', 'Belcher');
INSERT INTO passengers (first_name, last_name) VALUES('Linda', 'Belcher');
INSERT INTO passengers (first_name, last_name) VALUES('Tina', 'Belcher');
INSERT INTO passengers (first_name, last_name) VALUES('Gene', 'Belcher');
INSERT INTO passengers (first_name, last_name) VALUES('Louise', 'Belcher');

-- Flights
INSERT INTO flights (passenger_id, airline_name, departure_airport_code, departure_date) VALUES(1, 'Aerosmith', 'BOS', '2022-01-01');
INSERT INTO flights (passenger_id, airline_name, departure_airport_code, departure_date) VALUES(2, 'Aerosmith', 'BOS', '2022-02-01');

-- Flight Reviews
INSERT INTO flight_reviews (flight_id, passenger_id, was_on_time, seat_was_clean) VALUES(1, 1, 1, 0);
INSERT INTO flight_reviews (flight_id, passenger_id, was_on_time, seat_was_clean) VALUES(2, 2, 1, 1);