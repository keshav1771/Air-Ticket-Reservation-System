package com.flightbackend.api.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightbackend.api.dto.SourceDestDeptdto;
import com.flightbackend.api.model.Flight;
import com.flightbackend.api.model.Vendor;
import com.flightbackend.api.service.FlightService;


@RestController
public class FlightController {
	
	
	@Autowired
	private FlightService flightService;
	
	
	@PostMapping("flight/add/{vid}")
	public Flight addFlight(@RequestBody Flight flight, @PathVariable("vid") Long vid) {
		Vendor vendor = flightService.getVendorById(vid);
		if(vendor == null) {
			throw new RuntimeException("Vendor ID is Invalid..");
		}
		Double d = Math.random();
		String random = String.valueOf(d);
		flight.setFlight_number(random);
		flight.setVendor(vendor);
		List<Flight> list = getAllFlightsByVendorId(vid);
		list.stream().forEach(f -> {
			if(f.getSource().equals(flight.getSource()) && f.getDestination().equals(flight.getDestination())
														&& f.getDept_date().equals(flight.getDept_date())
														&& f.getArrival_date().equals(flight.getArrival_date())) {
				throw new RuntimeException("Flight already exists..");
			}
		});
		return flightService.addFlight(flight);
	}
	
	
	
	@GetMapping("flight/vendor/{vid}")
	public List<Flight> getAllFlightsByVendorId(@PathVariable("vid") Long vid) {
		return flightService.getAllFlightsByVendorId(vid);
	}
	
	@GetMapping("flight/getAll")
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}
	
	@PutMapping("flight/edit/{id}")
	public Flight editFlight(@RequestBody Flight newFlight, @PathVariable("id") Long id) {
		Flight flightDB = flightService.getFlightById(id);
		if(flightDB == null) {
			throw new RuntimeException("Flight ID is Invalid..");
		}
		Double d = Math.random();
		String random = String.valueOf(d);
		newFlight.setFlight_number(random);
		flightDB.setFlight_name(newFlight.getFlight_name());
		flightDB.setSource(newFlight.getSource());
		flightDB.setDestination(newFlight.getDestination());
		flightDB.setDept_date(newFlight.getDept_date());
		flightDB.setArrival_date(newFlight.getArrival_date());
		flightDB.setDept_time(newFlight.getDept_time());
		flightDB.setArrival_time(newFlight.getArrival_time());
		flightDB.setB_seats(newFlight.getB_seats());
		flightDB.setE_seats(newFlight.getE_seats());
		flightDB.setB_price(newFlight.getB_price());
		flightDB.setE_price(newFlight.getE_price());
		
		flightDB = flightService.addFlight(flightDB);
		return flightDB;
	}
	
	@DeleteMapping("flight/delete/{id}")
	public void deleteFlight(@PathVariable("id") Long id) {
		flightService.deleteFlight(id);
	}
	
	@GetMapping("getFlights/source/destination/deptdate")
	public List<Flight> getFlightsBySourceDestDept(@RequestBody SourceDestDeptdto dto) {
		System.out.println(dto);
		return flightService.getFlightsBySourceDestDept(dto.getSource(), dto.getDestination(), dto.getDept_date());
	}
   
}
