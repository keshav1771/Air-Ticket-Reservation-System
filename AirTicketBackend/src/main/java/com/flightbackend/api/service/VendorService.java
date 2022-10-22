package com.flightbackend.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbackend.api.model.Vendor;
import com.flightbackend.api.repository.VendorRepository;

@Service
public class VendorService {
	
	@Autowired
	private VendorRepository vendorRepository;
	
	public List<Vendor> getAllVendors() {
		return vendorRepository.findAll();
	}

	public Vendor getVendorById(Long id) {
		Optional<Vendor> optional = vendorRepository.findById(id);
		if(optional.isPresent()) {
			Vendor vendor = optional.get();
			return vendor;
		}
		return null;
	}

	public Vendor onboardOrRejectVendor(Vendor vendorDB) {
		return vendorRepository.save(vendorDB);
	}

	public void addVendor(Vendor vendor) {
		vendorRepository.save(vendor);
	}

	public Vendor editVendor(Vendor vendorDB) {
		return vendorRepository.save(vendorDB);
	}


}
