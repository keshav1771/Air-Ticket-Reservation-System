package com.hexaware.airlinereservationsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.hexaware.airlinereservationsystem.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
	public  List<Airport> findAirportByAirportName(String aptName);
}
