package com.flightbackend.api.dto;

public class CustomerDto {
	private Long id;
	private String name;
	private Long contact_number;
	private String address;
	private String gender;
	private Integer age;
	private String email;
	
	public CustomerDto(Long id, String name, Long contact_number, String address, String gender, Integer age,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.contact_number = contact_number;
		this.address = address;
		this.gender = gender;
		this.age = age;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", name=" + name + ", contact_number=" + contact_number + ", address="
				+ address + ", gender=" + gender + ", age=" + age + ", email=" + email + "]";
	}


}
