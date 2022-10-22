package com.flightbackend.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long contact_number;
	private String approval_status;

	@OneToOne
	private Users user;

	public Vendor() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContact_number() {
		return contact_number;
	}

	public void setContact_number(Long contact_number) {
		this.contact_number = contact_number;
	}

	public String getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", contact_number=" + contact_number + ", approval_status="
				+ approval_status + ", user=" + user + "]";
	}

	
}
