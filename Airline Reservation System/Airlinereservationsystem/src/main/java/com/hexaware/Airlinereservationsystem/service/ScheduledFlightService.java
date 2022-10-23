package com.hexaware.Airlinereservationsystem.service;

import java.math.BigInteger;


import com.hexaware.Airlinereservationsystem.exceptions.RecordNotFoundException;
import com.hexaware.Airlinereservationsystem.exceptions.ScheduledFlightNotFoundException;
import com.hexaware.Airlinereservationsystem.entity.ScheduledFlight;

public interface ScheduledFlightService {
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);

	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);

	public String removeScheduledFlight(BigInteger id) throws RecordNotFoundException;

	public Iterable<ScheduledFlight> viewAllScheduledFlights();

	public ScheduledFlight viewScheduledFlight(BigInteger id) throws ScheduledFlightNotFoundException;
	// boolean cancelBookings(BigInteger flightId) throws RecordNotFoundException;

}