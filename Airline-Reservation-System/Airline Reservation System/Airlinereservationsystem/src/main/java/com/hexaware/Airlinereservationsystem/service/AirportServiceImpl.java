package com.hexaware.Airlinereservationsystem.service;

import com.hexaware.Airlinereservationsystem.service.AirportService;
import java.math.BigInteger;
import java.util.Optional;

import com.hexaware.Airlinereservationsystem.entity.Airport;
import com.hexaware.Airlinereservationsystem.entity.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hexaware.Airlinereservationsystem.repository.AirportRepository;
import com.hexaware.Airlinereservationsystem.exceptions.RecordAlreadyPresentException;
import com.hexaware.Airlinereservationsystem.exceptions.RecordNotFoundException;

@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	AirportRepository airportrepository;

	/*
	 * view all Airports
	 */
	@Override
	public Iterable<Airport> viewAllAirport() {
		return airportrepository.findAll();
	}

	/*
	 * view airport by airportCode
	 */
	@Override
	public Airport viewAirport(String airportCode) {
		Optional<Airport> findById = airportrepository.findById(airportCode);
		if (findById.isPresent()) {
			return findById.get();
		}
			
			//return new ResponseEntity<Airport>(airport, HttpStatus.OK)}
		else
			throw new RecordNotFoundException("Airport with airport code: " + airportCode + "not exists");
	    }
		/*catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
        }*/

	/*
	 * add a airport
	 */
	@Override
	public ResponseEntity<?> addAirport(Airport airport) {
		Optional<Airport> findById = airportrepository.findById(airport.getAirportCode());
		try {
		if (!findById.isPresent()) {
			airportrepository.save(airport);
			return new ResponseEntity<Airport>(airport,HttpStatus.OK);
		} 
		else
			throw new RecordAlreadyPresentException(
					"Airport with code : " + airport.getAirportCode() + " already present");
	     }
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<Airport>(airport,HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * modify an Airport
	 */
	@Override
	public Airport modifyAirport(Airport airport) {
		Optional<Airport> findById = airportrepository.findById(airport.getAirportCode());
		if (findById.isPresent()) {
			airportrepository.save(airport);
		} 
		else
			throw new RecordNotFoundException("Airport with code: " + airport.getAirportCode() + " not exists");
		return airport;
	}

	/*
	 * remove an airport
	 */
	@Override
	public String removeAirport(String airportCode) {
		Optional<Airport> findById = airportrepository.findById(airportCode);
		if (findById.isPresent()) {
			airportrepository.deleteById(airportCode);
			return "Airport removed";
		} else
			throw new RecordNotFoundException("Airport with code: " + airportCode + " not exists");

	}
}
