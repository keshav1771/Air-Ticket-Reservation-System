package com.hexaware.airlinereservationsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.airlinereservationsystem.entity.User;
import com.hexaware.airlinereservationsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value="SELECT u FROM User u WHERE u.userName = ?1" )
	public User validateUser(String username);
	public List<User> findUsersByUserName(String usrName);
}
