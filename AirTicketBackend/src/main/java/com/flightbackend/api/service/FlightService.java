package com.flightbackend.api.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbackend.api.model.Flight;
import com.flightbackend.api.model.Vendor;
import com.flightbackend.api.repository.FlightRepository;
import com.flightbackend.api.repository.VendorRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private VendorRepository vendorRepository;

	public Vendor getVendorById(Long vid) {
		Optional<Vendor> optional = vendorRepository.findById(vid);
		if(optional.isPresent()) {
			Vendor vendor = optional.get();
			return vendor;
		}
		return null;
	}

	public Flight addFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	public List<Flight> getAllFlightsByVendorId(Long vid) {
		return flightRepository.getAllFlightsByVendorId(vid);
	}

	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	public Flight getFlightById(Long id) {
		Optional<Flight> optional = flightRepository.findById(id);
		if(optional.isPresent()) {
			Flight flight = optional.get();
			return flight;
		}
		return null;
	}

	public void deleteFlight(Long id) {
		flightRepository.deleteById(id);
		
	}

	public List<Flight> getFlightsBySourceDestDept(String source, String destination, LocalDate dept_date) {
		return flightRepository.getFlightsBySourceDestDept(source, destination, dept_date);
	}

	

}
