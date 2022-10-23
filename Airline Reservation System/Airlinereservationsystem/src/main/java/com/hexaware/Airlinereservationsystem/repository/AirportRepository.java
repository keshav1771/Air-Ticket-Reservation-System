package com.hexaware.Airlinereservationsystem.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hexaware.Airlinereservationsystem.entity.Airport;


@Repository
public interface AirportRepository extends CrudRepository<Airport, String> {

}


