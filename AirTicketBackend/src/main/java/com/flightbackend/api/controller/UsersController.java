package com.flightbackend.api.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbackend.api.dto.CustomerDto;
import com.flightbackend.api.dto.VendorDto;
import com.flightbackend.api.model.Admin;
import com.flightbackend.api.model.Customer;
import com.flightbackend.api.model.Users;
import com.flightbackend.api.model.Vendor;
import com.flightbackend.api.repository.AdminRepository;
import com.flightbackend.api.repository.CustomerRepository;
import com.flightbackend.api.repository.UsersRepository;
import com.flightbackend.api.repository.VendorRepository;

@RestController
public class UsersController {
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	@GetMapping("/user/login")
	public Users userLogin(Principal principal) {
		String email = principal.getName();

		Users user = usersRepository.findByEmail(email);
		return user;
	}

	@GetMapping("/user/details")
      public Object getUserDetails(Principal principal) {
      String email = principal.getName();
      Users user = usersRepository.findByEmail(email);
      
      if(user.getRole().equalsIgnoreCase("CUSTOMER")) {
    	  Customer customer = customerRepository.getCustomerDetails(email);
    	  CustomerDto dto = new CustomerDto(customer.getId(),
    			                          customer.getName(),
    			                          customer.getContact_number(),
    			                          customer.getAddress(),
    			                          customer.getGender(),
    			                          customer.getAge(),
    			                          email);
    	  return dto;
      }
      if(user.getRole().equalsIgnoreCase("VENDOR")) {
    	  Vendor vendor = vendorRepository.getVendorDetails(email);
    	  VendorDto dto = new VendorDto(vendor.getId(),
    			                        vendor.getName(),
    			                        vendor.getApproval_status(),
    			                        vendor.getContact_number(),
    			                        email);
    	  return dto;
      }
      if(user.getRole().equalsIgnoreCase("ADMIN")) {
    	  Admin admin = adminRepository.getAdminDetails(email);
    	  return admin;
      }
      return null;
}
}