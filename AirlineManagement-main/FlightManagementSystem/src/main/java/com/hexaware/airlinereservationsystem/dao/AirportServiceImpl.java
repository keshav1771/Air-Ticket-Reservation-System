package com.hexaware.airlinereservationsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.airlinereservationsystem.entity.Airport;
import com.hexaware.airlinereservationsystem.exception.AirportNotFoundException;
import com.hexaware.airlinereservationsystem.repository.AirportRepository;
import com.hexaware.airlinereservationsystem.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService{
	@Autowired
	private AirportRepository repo;
	
	@Override
	public Airport addAirport(Airport airport) {
		return repo.save(airport);
	}
	
	@Override
	public List<Airport> viewAirport(){
		return repo.findAll();
	}
	
	@Override
    public Airport viewAirport(int airportCode) throws AirportNotFoundException{
		Optional<Airport> found = repo.findById(airportCode);
		if (found.isPresent()) {
			return found.get();
		}else{
			throw new AirportNotFoundException("Airport with airport code: " + airportCode + " does not exists");
		}
	}


	@Override
	public List<Airport> getAirportByName(String airportName) {
		// TODO Auto-generated method stub
		return repo.findAirportByAirportName(airportName);
	}
}
