package com.flightbackend.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long contact_number;
	private String address;
	private String gender;
	private Integer age;
	
	@OneToOne
	private Users user;
	
	
	public Customer() {
		
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


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contact_number=" + contact_number + ", address=" + address
				+ ", gender=" + gender + ", age=" + age + ", user=" + user + "]";
	}

}
