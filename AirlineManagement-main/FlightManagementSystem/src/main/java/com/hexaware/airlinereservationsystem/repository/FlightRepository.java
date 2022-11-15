package com.hexaware.airlinereservationsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.airlinereservationsystem.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
	public List<Flight> findFlightByFlightModel(String fliModel);

}
