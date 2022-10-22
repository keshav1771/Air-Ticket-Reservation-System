package com.flightbackend.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbackend.api.model.CustomerFlight;

public interface CustomerFlightRepository extends JpaRepository<CustomerFlight, Long> {
    
	List<CustomerFlight> getBookingsByCustomerId(Long cid);
	List<CustomerFlight> getBookingsByVendorId(Long vid);
	
	

}
