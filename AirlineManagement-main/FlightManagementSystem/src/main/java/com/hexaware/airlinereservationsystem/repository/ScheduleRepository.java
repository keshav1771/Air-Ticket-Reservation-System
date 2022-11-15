package com.hexaware.airlinereservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.airlinereservationsystem.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}