package com.flightbackend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightbackend.api.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
    
	@Query("select c from Customer c where c.user.email=?1")
     Customer getCustomerDetails(String email);
}
