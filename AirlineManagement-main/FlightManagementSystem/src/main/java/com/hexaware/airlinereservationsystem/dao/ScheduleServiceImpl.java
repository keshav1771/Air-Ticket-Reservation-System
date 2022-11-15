package com.hexaware.airlinereservationsystem.dao;

import com.hexaware.airlinereservationsystem.entity.Schedule;
import com.hexaware.airlinereservationsystem.repository.ScheduleRepository;
import com.hexaware.airlinereservationsystem.service.ScheduleService;

import java.util.List;

import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Proxy(lazy=false)
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleRepository repo;

	@Override
	public Schedule createSchedule(Schedule schedule) {
		return repo.save(schedule);
	}
	
	@Override
	public List<Schedule> viewSchedules(){
		return repo.findAll();
	}
}
