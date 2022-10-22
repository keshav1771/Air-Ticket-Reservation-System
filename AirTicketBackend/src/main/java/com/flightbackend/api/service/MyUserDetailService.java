package com.flightbackend.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flightbackend.api.model.Users;
import com.flightbackend.api.repository.UsersRepository;

@Service
public class MyUserDetailService  implements UserDetailsService{
	@Autowired
private UsersRepository usersRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users users = usersRepository.findByEmail(email) ;
		if(users == null)
			throw new UsernameNotFoundException("Invalid credentials");
		
		return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(),
				users.getAuthorities());
	}

}
