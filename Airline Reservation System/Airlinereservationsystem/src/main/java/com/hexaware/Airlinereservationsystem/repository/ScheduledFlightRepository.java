package com.hexaware.Airlinereservationsystem.repository;
import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.Airlinereservationsystem.entity.ScheduledFlight;
public interface ScheduledFlightRepository extends CrudRepository<ScheduledFlight, BigInteger>{

}
