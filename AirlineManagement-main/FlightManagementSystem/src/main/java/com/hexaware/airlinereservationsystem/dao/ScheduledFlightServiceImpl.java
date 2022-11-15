package com.hexaware.airlinereservationsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.airlinereservationsystem.entity.Flight;
import com.hexaware.airlinereservationsystem.entity.Schedule;
import com.hexaware.airlinereservationsystem.entity.ScheduledFlight;
import com.hexaware.airlinereservationsystem.repository.FlightRepository;
import com.hexaware.airlinereservationsystem.repository.ScheduleRepository;
import com.hexaware.airlinereservationsystem.repository.ScheduledFlightRepository;
import com.hexaware.airlinereservationsystem.service.ScheduledFlightService;

@Service
@Proxy(lazy=false)
public class ScheduledFlightServiceImpl implements ScheduledFlightService{
	@Autowired
	private ScheduledFlightRepository repo;
	
	@Autowired
	private ScheduleRepository repo1;
	
	@Autowired
	private FlightRepository repo2;
	
	@Override
	public ScheduledFlight addScheduleFlight(ScheduledFlight flight, int scheduleId, int flightNumber) {
		Schedule schedule = repo1.getById(scheduleId);
		Flight realFlight = repo2.getById(flightNumber);
		flight.setSchedule(schedule);
		flight.setFlight(realFlight);
		return repo.save(flight);
	}	
	@Override
	public List<ScheduledFlight> viewScheduledFlights(){
		return repo.findAll();
	}
	@Override
	public ScheduledFlight viewScheduledFlights(int num){
		return repo.getById(num);
	}
	@Override
	public List<ScheduledFlight> viewScheduledFlight(int flightno){
		List<ScheduledFlight> ans = new ArrayList<>();
		List<ScheduledFlight> list = repo.findAll();
		for(ScheduledFlight s: list) {
			if(s.getFlight().getFlightNumber()==flightno) {
				ans.add(s);
			}
		}
		return ans;
	}
	@Override
	public void deleteScheduledFlight(int flightno){
		repo.deleteScheduledFlight(flightno);
	}
	@Override
	public ScheduledFlight modifyFlightSchedule(ScheduledFlight flight) {
		return repo.save(flight);
	}
}