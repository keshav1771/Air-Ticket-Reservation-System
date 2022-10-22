package com.flightbackend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightbackend.api.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	@Query("select a from Admin a where a.user.email=?1")
	Admin getAdminDetails(String email);

}
