package com.hexaware.airlinereservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.airlinereservationsystem.entity.Passenger;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
