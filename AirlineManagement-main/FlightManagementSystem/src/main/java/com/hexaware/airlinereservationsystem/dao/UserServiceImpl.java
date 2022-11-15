package com.hexaware.airlinereservationsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.airlinereservationsystem.entity.User;
import com.hexaware.airlinereservationsystem.exception.UserNotFoundException;
import com.hexaware.airlinereservationsystem.repository.UserRepository;
import com.hexaware.airlinereservationsystem.service.UserService;
import com.hexaware.airlinereservationsystem.entity.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository repo;
	
	@Override
	public User addUser(User user) {
		return repo.save(user);
	}
	
	@Override
	public User viewUser(int userId) throws UserNotFoundException {
		Optional<User> found = repo.findById(userId);
		if(found.isPresent()) {
			return found.get();
		}else {
			throw new UserNotFoundException("This user does not exist");
		}
	}
	
	@Override
	public List<User> viewUser(){
		return repo.findAll();
	}
	
	@Override
	public User updateUser(User user) {
		return repo.save(user);
	}
	
	@Override
	public void deleteUser(int userId) {
		repo.delete(repo.getById(userId));
	}
	
	@Override
	public boolean validateUser(String userName, String password) {
		boolean result = false;
		User validate = repo.validateUser(userName);
		if (validate != null) {
			String validPassword = validate.getPassword();
			if (validPassword.equals(password)) {
				result = true;
			}

		}
		return result;
	}

	@Override
	public int getUserByName(String UserName) {
		User u = repo.validateUser(UserName);
		int id = u.getUserId();
		return id;
	}

	@Override
	public String getUserType(int UserId) {
		User u = repo.getById(UserId);
		String type=u.getUserType();
		return type;
	}

	@Override
	public List<User> getUsersByName(String userName) {
		// TODO Auto-generated method stub
		return repo.findUsersByUserName(userName);
	}
}
