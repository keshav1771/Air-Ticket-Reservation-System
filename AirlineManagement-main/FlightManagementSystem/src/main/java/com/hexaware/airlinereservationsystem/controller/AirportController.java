package com.hexaware.airlinereservationsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.airlinereservationsystem.dao.AirportServiceImpl;
import com.hexaware.airlinereservationsystem.entity.Airport;
import com.hexaware.airlinereservationsystem.exception.AirportNotFoundException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@RequestMapping("/airport")
public class AirportController {
	Logger logger=org.slf4j.LoggerFactory.getLogger(AirportController.class);
	
	@Autowired
	private AirportServiceImpl dao;
	
	//localhost:5010/airline-api/airport/airports
	@GetMapping(path="/airports")
	
	public ResponseEntity<List<Airport>> viewAllAirports(){
		ResponseEntity<List<Airport>> response = null;
		List<Airport> list = dao.viewAirport();
		response = new ResponseEntity<List<Airport>>(list, HttpStatus.OK);
		return response;
	}
	
	//localhost:5010/airline-api/airport/airports/:airportCode
	@GetMapping(path="/airports/{airportCode}")
	
	public Airport viewAirport(@PathVariable("airportCode") int airportCode) throws AirportNotFoundException{
		return dao.viewAirport(airportCode);
	}
	
	//localhost:5010/airline-api/airport/addAirport
	@PostMapping(path="/addAirport")
	
	public Airport addAirport(@RequestBody Airport airport) {
		logger.info("Airport added to the database");
		return dao.addAirport(airport);
	}
}
