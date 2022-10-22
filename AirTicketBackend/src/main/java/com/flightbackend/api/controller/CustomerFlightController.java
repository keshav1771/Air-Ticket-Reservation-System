package com.flightbackend.api.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightbackend.api.model.Customer;
import com.flightbackend.api.model.CustomerFlight;
import com.flightbackend.api.model.Flight;
import com.flightbackend.api.model.Vendor;
import com.flightbackend.api.repository.CustomerFlightRepository;
import com.flightbackend.api.repository.CustomerRepository;
import com.flightbackend.api.repository.VendorRepository;
import com.flightbackend.api.service.CustomerFlightService;
import com.flightbackend.api.service.CustomerService;
import com.flightbackend.api.service.FlightService;

@RestController
public class CustomerFlightController {
	
	@Autowired
	private CustomerFlightService customerFlightService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private FlightService flightService;
	
	
	@PostMapping("/customer/bookFlight/{cid}/{fid}")
	public CustomerFlight bookFlight(@RequestBody CustomerFlight custFlight,
									 @PathVariable("cid") Long cid,
									 @PathVariable("fid") Long fid) {
		Customer customerDB = customerService.getCustomerById(cid);
		if(customerDB == null) {
			throw new RuntimeException("Customer ID is Invalid..");
		}
		Flight flightDB = flightService.getFlightById(fid);
		if(flightDB == null) {
			throw new RuntimeException("Flight ID is Invalid..");
		}
		Vendor vendorDB = flightDB.getVendor();
		
		if(custFlight.getSeat_type().equalsIgnoreCase("Business")) {
			
			custFlight.setVendor(vendorDB);
			Integer currentSeats = flightDB.getB_seats() - custFlight.getNo_of_seats();
			flightDB.setB_seats(currentSeats);
			custFlight.setFlight(flightDB);
				
			Double total_amount = custFlight.getNo_of_seats() * flightDB.getB_price();
			custFlight.setCustomer(customerDB);
				
			custFlight.setBooking_date(LocalDateTime.now());
			custFlight.setTotal_amount(total_amount);
			Double d = Math.random();
			String random = String.valueOf(d);
			custFlight.setBooking_number(random);
			String status = "Booked";
			custFlight.setStatus(status);
				
			return customerFlightService.bookFlight(custFlight);
		}
		
		if(custFlight.getSeat_type().equalsIgnoreCase("Economy")) {

			custFlight.setVendor(vendorDB);
			Integer currentSeats = flightDB.getE_seats() - custFlight.getNo_of_seats();
			flightDB.setE_seats(currentSeats);
			custFlight.setFlight(flightDB);
				
			Double total_amount = custFlight.getNo_of_seats() * flightDB.getE_price();
			custFlight.setCustomer(customerDB);
				
			custFlight.setBooking_date(LocalDateTime.now());
			custFlight.setTotal_amount(total_amount);
			Double d = Math.random();
			String random = String.valueOf(d);
			custFlight.setBooking_number(random);
			String status = "Booked";
			custFlight.setStatus(status);
				
			return customerFlightService.bookFlight(custFlight);
		}
		
		return null;
		
	}
	
	@GetMapping("/booking/customer/{cid}")
	public List<CustomerFlight> getCustomerBookingDetails(@PathVariable("cid")Long cid) {
		
		return customerFlightService.getCustomerBookingDetails(cid);
		
	}
	@GetMapping("/booking/vendor/{vid}")
	public List<CustomerFlight> getVendorBookingDetails (@PathVariable("vid") Long vid) {
		return customerFlightService.getVendorBookingDetails(vid);
		
	}
	    @PutMapping("/customer/cancel/flight/{bid}")
	    public CustomerFlight cancelBooking(@PathVariable("bid") Long bid) {
	                CustomerFlight cfdb = customerFlightService.getBookingById(bid);
	                if(cfdb == null) {
	                	throw new RuntimeException("Booking Id is Invalid...");
	                }
	                Flight flightdb = cfdb.getFlight();  
	                if(cfdb.getSeat_type().equalsIgnoreCase("Business")) {
	                	Integer updatedseats = flightdb.getB_seats() + cfdb.getNo_of_seats();
	                	flightdb.setB_seats(updatedseats);
	                	cfdb.setFlight(flightdb);
	                	String status = "Cancelled";
	                	cfdb.setStatus(status);
	                	return customerFlightService.cancelBooking(cfdb);
	                }
	                if(cfdb.getSeat_type().equalsIgnoreCase("Economy")){
	                	Integer updatedseats = flightdb.getE_seats() + cfdb.getNo_of_seats();
	                	flightdb.setE_seats(updatedseats);
	                	cfdb.setFlight(flightdb);
	                	String status = "Cancelled";
	                	cfdb.setStatus(status);
	                	return customerFlightService.cancelBooking(cfdb);
	                }
	               return null;
	               
	    }
	
}
