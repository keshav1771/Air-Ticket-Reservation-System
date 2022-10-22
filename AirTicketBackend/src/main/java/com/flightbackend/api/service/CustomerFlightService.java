package com.flightbackend.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbackend.api.model.CustomerFlight;
import com.flightbackend.api.repository.CustomerFlightRepository;

@Service
public class CustomerFlightService {
	
	@Autowired
	private CustomerFlightRepository customerFlightRepository;

	public CustomerFlight bookFlight(CustomerFlight custFlight) {
		return customerFlightRepository.save(custFlight);
	}

	public List<CustomerFlight> getCustomerBookingDetails(Long cid) {
		
		return customerFlightRepository.getBookingsByCustomerId(cid);
	}
	
	public List<CustomerFlight> getVendorBookingDetails(Long vid) {
		return customerFlightRepository.getBookingsByVendorId(vid);
		
	}
	

	public CustomerFlight getBookingById(Long bid) {
		Optional<CustomerFlight> optional = customerFlightRepository.findById(bid);
		if( optional.isPresent()) {
			CustomerFlight customerFlight = optional.get();
			return customerFlight;
		}
			
		return null;
	}

	public CustomerFlight cancelBooking(CustomerFlight customerFlight) {
		
		return customerFlightRepository.save(customerFlight);
	}
	
	

	

}
