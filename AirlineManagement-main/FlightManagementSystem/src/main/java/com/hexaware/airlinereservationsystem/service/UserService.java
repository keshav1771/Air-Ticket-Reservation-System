package com.hexaware.airlinereservationsystem.service;

import java.util.List;

import com.hexaware.airlinereservationsystem.entity.User;
import com.hexaware.airlinereservationsystem.exception.UserNotFoundException;
import com.hexaware.airlinereservationsystem.entity.User;

public interface UserService {
	// create a new user and add it in the database
	public User addUser(User user);

	// view user details from its given user ID
	public User viewUser(int userId) throws UserNotFoundException;

	// view a list of all users
	public List<User> viewUser();

	// update user details
	public User updateUser(User user);

	// delete the user from the database
	public void deleteUser(int userId);

	public int getUserByName(String UserName);
	public boolean validateUser(String userName, String password);
	public String getUserType(int userId);
	public List<User> getUsersByName(String userName);
}
