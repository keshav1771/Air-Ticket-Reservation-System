package com.flightbackend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightbackend.api.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
	@Query("select v from Vendor v where v.user.email=?1")
	 Vendor getVendorDetails(String email);

}
