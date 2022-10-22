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

import com.flightbackend.api.model.Users;
import com.flightbackend.api.model.Vendor;
import com.flightbackend.api.repository.UsersRepository;
import com.flightbackend.api.service.VendorService;

@RestController
public class VendorController {
	@Autowired
	private VendorService vendorService;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UsersRepository usersRepository;

	@PostMapping("/vendor/add")
	public void addVendor(@RequestBody Vendor vendor) {
		Users user = vendor.getUser();
		if (user == null) {
			throw new RuntimeException("user data not present");
		}

		user.setRole("VENDOR");

		String encryptedPassword = encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		user = usersRepository.save(user);

		String approval_status = "In Process";
		vendor.setApproval_status(approval_status);
		vendor.setUser(user);
		vendorService.addVendor(vendor);
	}

	@GetMapping("vendor/getAll")
	public List<Vendor> getAllVendors() {
		return vendorService.getAllVendors();
	}

	@PutMapping("admin/approveOrrejectVendor/{id}")
	public Vendor onboardOrRejectVendor(@RequestBody Vendor newVendor, @PathVariable("id") Long id) {
		Vendor vendorDB = vendorService.getVendorById(id);
		if (vendorDB == null) {
			throw new RuntimeException("Vendor ID is Invalid..");
		}
		vendorDB.setApproval_status(newVendor.getApproval_status());
		vendorDB = vendorService.onboardOrRejectVendor(vendorDB);
		return vendorDB;
	}

}
