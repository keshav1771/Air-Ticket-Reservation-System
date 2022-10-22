package com.flightbackend.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightbackend.api.model.Admin;
import com.flightbackend.api.model.Users;
import com.flightbackend.api.repository.AdminRepository;
import com.flightbackend.api.repository.UsersRepository;

@RestController
public class AdminController {
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("admin/add")
	public void addAdmin(@RequestBody Admin admin) {
		Users users  = admin.getUser();
		if(users == null) {
			throw new RuntimeException("Invalid user Id..");			
		}
		users.setRole("ADMIN");
		String encrypassword = encoder.encode(users.getPassword());
		users.setPassword(encrypassword);
		
		users = usersRepository.save(users);
		admin.setUser(users);
		adminRepository.save(admin);
	}
	

}
