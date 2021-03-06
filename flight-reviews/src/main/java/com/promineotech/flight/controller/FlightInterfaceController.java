package com.promineotech.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.flight.entity.Flight;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/flights")
@OpenAPIDefinition(info = @Info(title = "Flight"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

public interface FlightInterfaceController {
	// @formatter:off
	@Operation(
			summary = "Delete flight",
			description = "Flight deleted",
			responses = {
					@ApiResponse(
							responseCode = "204", 
							description = "The flight was deleted") 
							/*content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Flight.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid",  
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", description = "No passengers were found with the input criteria",  
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured",  
							content = @Content(mediaType = "application/json"))
*/
			},
			parameters = {
					@Parameter(
							name = "flightId", 
							allowEmptyValue = false, 
							required = true, 
							description = "Flight ID")
			}
			)
	// @formatter:on
	@DeleteMapping("/Delete")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deleteFlight(int flightId);

}
