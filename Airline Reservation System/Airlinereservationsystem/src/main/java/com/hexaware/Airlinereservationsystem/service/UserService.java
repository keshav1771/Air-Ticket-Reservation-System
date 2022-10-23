package com.hexaware.Airlinereservationsystem.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.hexaware.Airlinereservationsystem.entity.Users;

public interface UserService {

	public ResponseEntity<?> createUser(Users newUser);

	public Users updateUser(Users newUser);

	public String deleteUser(BigInteger UserId);

	public Iterable<Users> displayAllUser();

	public ResponseEntity<?> findUserById(BigInteger userId);
}
