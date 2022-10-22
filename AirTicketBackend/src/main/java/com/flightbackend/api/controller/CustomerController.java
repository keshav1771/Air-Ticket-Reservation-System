package com.flightbackend.api.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightbackend.api.model.Customer;
import com.flightbackend.api.model.Users;
import com.flightbackend.api.repository.CustomerRepository;
import com.flightbackend.api.repository.UsersRepository;
import com.flightbackend.api.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer/add")
	public void addCustomer(@RequestBody Customer customer) {
		
		Users users=customer.getUser();
		if(users==null) {
			throw new RuntimeException("user data not present");
		}
		
		users.setRole("CUSTOMER");
		
		String encryptedPassword=encoder.encode(users.getPassword());
		users.setPassword(encryptedPassword);
		users=usersRepository.save(users);
		customer.setUser(users);;
		customerRepository.save(customer);
		
		
	}
	
	@GetMapping("/customer/getAll")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	
	@PutMapping("/customer/edit/{id}")
	public Customer editCustomer(@PathVariable("id") Long id, @RequestBody Customer customernew) {
		Customer customerDB= customerService.getCustomerById(id);
		if (customerDB == null)
			throw new RuntimeException("ID Invalid");
		
		Users user=customerDB.getUser();
		
		Users newUser=customernew.getUser();
		user.setEmail(newUser.getEmail());
		customerDB.setName(customernew.getName());
		customerDB.setContact_number(customernew.getContact_number());
		customerDB.setAddress(customernew.getAddress());
		customerDB.setGender(customernew.getGender());
		customerDB.setAge(customernew.getAge());
		customerDB.setUser(user);

		return customerService.editCustomer(customerDB);
		
	}
}
