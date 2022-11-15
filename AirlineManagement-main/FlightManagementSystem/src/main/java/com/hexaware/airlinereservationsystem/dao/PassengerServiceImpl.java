package com.hexaware.airlinereservationsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.airlinereservationsystem.entity.Booking;
import com.hexaware.airlinereservationsystem.entity.Passenger;
import com.hexaware.airlinereservationsystem.repository.BookingRepository;
import com.hexaware.airlinereservationsystem.repository.PassengerRepository;
import com.hexaware.airlinereservationsystem.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	private PassengerRepository repo;
	
	@Autowired
	private BookingRepository repo1;

	@Override
	public Passenger getPassengerById(int pnrNumber) {
		Passenger p= repo.getById(pnrNumber);
		return p;
	}

	@Override
	public int updatePassenger(Passenger passenger, int bookingId) {
		int result=0;
		Booking B= repo1.getById(bookingId);
		passenger.setBooking(B);
		Passenger n=repo.save(passenger);
		if(n!=null) {
			result=1;
		}
		return result;
	}

	public List<Booking> getBookingByDate(String bdate) {
		// TODO Auto-generated method stub
		return null;
	}
}
