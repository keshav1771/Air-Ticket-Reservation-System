package com.hexaware.airlinereservationsystem.service;

import java.util.List;

import com.hexaware.airlinereservationsystem.entity.Airport;
import com.hexaware.airlinereservationsystem.exception.AirportNotFoundException;

public interface AirportService {
    // add an airport to the database
	public Airport addAirport(Airport airport);

    // view all airports in the database
    public List<Airport> viewAirport();

    // view an airport using its airport code
    public Airport viewAirport(int airportCode) throws AirportNotFoundException;
	List <Airport> getAirportByName(String airportName);
}
