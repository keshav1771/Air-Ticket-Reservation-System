package com.hexaware.airlinereservationsystem.service;

import java.util.List;

import com.hexaware.airlinereservationsystem.entity.Schedule;

public interface ScheduleService  {
	// create a new schedule and add it to the database
	public Schedule createSchedule(Schedule schedule);
	
	// view all schedules
	public List<Schedule> viewSchedules();
}