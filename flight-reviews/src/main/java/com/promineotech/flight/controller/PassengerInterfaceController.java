package com.promineotech.flight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.promineotech.flight.entity.Passenger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.Parameter;

@OpenAPIDefinition(info = @Info(title = "List of Passengers"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})
@RequestMapping("/passengers")
public interface PassengerInterfaceController {
	//GET
	// @formatter:off
	@Operation(
			summary = "Returns a passenger",
			description = "Reutrns a passenger",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "A passenger is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Passenger.class))),
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

			},
			parameters = {
					@Parameter(
							name = "firstName", 
							allowEmptyValue = false, 
							required = true, 
							description = "Passenger First Name"),
					@Parameter(
							name = "lastName", 
							allowEmptyValue = false, 
							required = true, 
							description = "Passenger Last Name")
			}
			)
	// @formatter:on
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Passenger> fetchPassengers(String firstName, String lastName);

// POST
// @formatter:off
@Operation(
		summary = "Creates a new passenger",
		description = "Creates a new passenger",
		responses = {
				@ApiResponse(
						responseCode = "201", 
						description = "A passenger is returned", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = Passenger.class))),
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

		},
		parameters = {
				@Parameter(
						name = "firstName", 
						allowEmptyValue = false, 
						required = true, 
						description = "Passenger First Name"),
				@Parameter(
						name = "lastName", 
						allowEmptyValue = false, 
						required = true, 
						description = "Passenger Last Name")
		}
		)
// @formatter:on
@PostMapping("/create")
@ResponseStatus(code = HttpStatus.CREATED)
Passenger createPassenger(String firstName, String lastName);


// PUT/UPDATE
// @formatter:off
@Operation(
		summary = "Returns an updated passenger",
		description = "Reutrns a list of passengers",
		responses = {
				@ApiResponse(
						responseCode = "200", 
						description = "The passenger was updated", 
						content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = Passenger.class))),
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

		},
		parameters = {
				@Parameter(
						name = "passengerId", 
						allowEmptyValue = false, 
						required = false, 
						description = "Passenger ID"),
				@Parameter(
						name = "firstName", 
						allowEmptyValue = true, 
						required = false, 
						description = "Passenger First Name"),
				@Parameter(
						name = "lastName", 
						allowEmptyValue = true, 
						required = false, 
						description = "Passenger Last Name")
				
		}
		)
// @formatter:on
@PutMapping("/Update")
@ResponseStatus(code = HttpStatus.OK)
Passenger updatePassenger(int passengerId, String firstName, String lastName,  @Valid @RequestBody Passenger updatePassenger);

//DELETE
//@formatter:off
@Operation(
		summary = "Deletes a passenger",
		description = "Deleted passenger",
		responses = {
				@ApiResponse(
						responseCode = "204", 
						description = "The passenger was deleted")
						/*content = @Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = Passenger.class))),
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
						content = @Content(mediaType = "application/json"))*/

		},
		parameters = {
				@Parameter(
						name = "passengerId", 
						allowEmptyValue = false, 
						required = true, 
						description = "Passenger ID")
		}
		)
// @formatter:on
@DeleteMapping("/Delete")
@ResponseStatus(code = HttpStatus.NO_CONTENT)
void deletePassenger(int passengerId);


}