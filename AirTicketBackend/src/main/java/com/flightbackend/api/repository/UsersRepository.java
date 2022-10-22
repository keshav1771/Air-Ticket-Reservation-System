package com.flightbackend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbackend.api.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByEmail(String email);

	

}



