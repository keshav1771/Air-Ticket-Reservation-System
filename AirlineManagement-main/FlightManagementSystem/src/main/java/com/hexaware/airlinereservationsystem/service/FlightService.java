package com.hexaware.airlinereservationsystem.service;

import java.util.List;

import com.hexaware.airlinereservationsystem.entity.Flight;
import com.hexaware.airlinereservationsystem.exception.FlightNotFoundException;

public interface FlightService {
	// create a new flight and add it to the the database
	public Flight addFlight(Flight flight);

	// view a flight using its flight number
	public Flight viewFlight(int flightno) throws FlightNotFoundException;

	// view all flights in the database
	public List<Flight> viewFlight();

	// delete a flight using the flight number
	public void deleteFlight(int flightno);

	// modify a flight using the flight number
	public Flight modifyFlight(Flight flight);
	public List<Flight> getFlightByModel(String flightModel);
}
