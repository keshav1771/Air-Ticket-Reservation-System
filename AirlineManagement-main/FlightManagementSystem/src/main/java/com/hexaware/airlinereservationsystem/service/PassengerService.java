package com.hexaware.airlinereservationsystem.service;

import com.hexaware.airlinereservationsystem.entity.Passenger;

public interface PassengerService {
	public Passenger getPassengerById(int pnrNumber);
	
	public int updatePassenger(Passenger passenger,int bookingId);
}