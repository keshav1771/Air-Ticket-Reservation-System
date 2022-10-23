package com.hexaware.Airlinereservationsystem.repository;
import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import com.hexaware.Airlinereservationsystem.entity.Users;
public interface UserRepository extends CrudRepository<Users, BigInteger>{

}
