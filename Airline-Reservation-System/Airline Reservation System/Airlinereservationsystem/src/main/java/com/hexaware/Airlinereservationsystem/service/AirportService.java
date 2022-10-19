package com.hexaware.Airlinereservationsystem.service;

import org.springframework.http.ResponseEntity;

import com.hexaware.Airlinereservationsystem.entity.Airport;

public interface AirportService {
	public Iterable<Airport> viewAllAirport();

	public Airport viewAirport(String airportCode);

	public ResponseEntity<?> addAirport(Airport airport);

	public Airport modifyAirport(Airport airport);

	public String removeAirport(String airportCode);
}