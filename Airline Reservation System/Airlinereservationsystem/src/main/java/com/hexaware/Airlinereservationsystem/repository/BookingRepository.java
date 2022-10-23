package com.hexaware.Airlinereservationsystem.repository;
import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.Airlinereservationsystem.entity.Booking;
public interface BookingRepository extends CrudRepository<Booking, BigInteger> {

}


