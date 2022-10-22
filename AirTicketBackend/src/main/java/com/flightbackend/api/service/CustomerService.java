package com.flightbackend.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbackend.api.model.Customer;
import com.flightbackend.api.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer editCustomer(Customer customerDB) {
	
		return customerRepository.save(customerDB);
	}

	public Customer getCustomerById(Long id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isPresent()) {
			Customer customer = optional.get();
			return customer;
		}
		return null;
	}

}
