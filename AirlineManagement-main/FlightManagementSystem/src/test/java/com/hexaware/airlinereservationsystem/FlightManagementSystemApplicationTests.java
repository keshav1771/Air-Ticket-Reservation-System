package com.hexaware.airlinereservationsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.airlinereservationsystem.dao.AirportServiceImpl;
import com.hexaware.airlinereservationsystem.dao.FlightServiceImpl;
import com.hexaware.airlinereservationsystem.dao.UserServiceImpl;
import com.hexaware.airlinereservationsystem.entity.Airport;
import com.hexaware.airlinereservationsystem.entity.Flight;
import com.hexaware.airlinereservationsystem.entity.User;

@SpringBootTest
class FlightManagementSystemApplicationTests {

	@Autowired
	private AirportServiceImpl airService;
	@Autowired
	private FlightServiceImpl flightService;
	@Autowired
	private UserServiceImpl userService;

	@Test
	public void testAddAirportMethod() {
	    Airport a = new Airport(1010, "XYZ City Airport", "XYZ City");
		Airport check = airService.addAirport(a);
        assertEquals(a.getAirportCode(), check.getAirportCode());
        assertEquals(a.getAirportName(), check.getAirportName());
        assertEquals(a.getAirportLocation(), check.getAirportLocation());
	}
	
	@Test
	public void testAddFlightMethod() {
		Flight f = new Flight(600600, "PQR Airways", "F-22", 80);
		Flight check = flightService.addFlight(f);
		assertEquals(f.getFlightNumber(), check.getFlightNumber());
        assertEquals(f.getCarrierName(), check.getCarrierName());
        assertEquals(f.getFlightModel(), check.getFlightModel());
	}
	
	@Test
	public void testAddUserMethod() {
		User u = new User(27, "Customer", "John", "password", "john@email.com", "1234567890");
		User check = userService.addUser(u);
		assertEquals(u.getMobileNumber(), check.getMobileNumber());
        assertEquals(u.getEmail(), check.getEmail());
        assertEquals(u.getUserId(), check.getUserId());
        assertEquals(u.getPassword(), check.getPassword());
	}
}
