package com.flightbackend.api.dto;

public class VendorDto {
	private Long id;
	private String name;
	private Long contact_number;
	private String approval_status;
	private String email;
	
	

	public VendorDto(Long id, String name, String approval_status, Long contact_number, String email) {
		super();
		this.id = id;
		this.name = name;
		this.contact_number = contact_number;
		this.approval_status = approval_status;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
