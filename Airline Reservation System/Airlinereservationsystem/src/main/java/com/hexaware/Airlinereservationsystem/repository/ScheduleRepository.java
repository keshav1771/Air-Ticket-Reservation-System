package com.hexaware.Airlinereservationsystem.repository;
import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.Airlinereservationsystem.entity.Schedule;
public interface ScheduleRepository extends CrudRepository<Schedule, BigInteger>{

}
