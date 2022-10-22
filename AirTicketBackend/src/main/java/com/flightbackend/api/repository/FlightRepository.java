package com.flightbackend.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightbackend.api.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	List<Flight> getAllFlightsByVendorId(Long vid);
	
	@Query("select f from Flight f where f.source=?1 AND f.destination=?2 AND f.dept_date=?3")
	List<Flight> getFlightsBySourceDestDept(String source, String destination, LocalDate dept_date);
	

}
