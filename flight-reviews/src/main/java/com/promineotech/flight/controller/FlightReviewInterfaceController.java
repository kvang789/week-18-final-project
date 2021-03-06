package com.promineotech.flight.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.flight.entity.FlightReview;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/flightReviews")
@OpenAPIDefinition(info = @Info(title = "Flight Review"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})
public interface FlightReviewInterfaceController {
	// @formatter:off
	@Operation(
			summary = "Returns a flight review for a flight",
			description = "Returns the created flight review",
			responses = {
					@ApiResponse(responseCode = "200", 
							description = "A flight review is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = FlightReview.class))),
					@ApiResponse(responseCode = "400", 
					description = "Request paramters are invalid.", 
					content = @Content(mediaType = "application/json")),
					@ApiResponse(responseCode = "404", 
					description = "A flight review component was not found with the input criteria.", 
					content = @Content(mediaType = "application/json")),
					@ApiResponse(responseCode = "500", 
					description = "An unplanned error occurred.", 
					content = @Content(mediaType = "application/json"))
			},
			parameters = {
					@Parameter(name = "flightReviewId", 
							required = true, 
							description = "Enter flight review ID")
			}
			)

	// @formatter:on
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<FlightReview> fetchFlightReviews(int flightReviewId); 

}
