package com.flightbackend.api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String flight_name;
	private String flight_number;
	private String source;
	private String destination;
	private LocalDate dept_date;
	private LocalDate arrival_date;
	private LocalTime dept_time;
	private LocalTime arrival_time;
	private Integer b_seats;
	private Integer e_seats;
	private Double b_price;
	private Double e_price;
	
	@ManyToOne
	private Vendor vendor;

	public Flight() {
		
	}

	public Flight(Long id, String flight_name, String flight_number, String source, String destination,
			LocalDate dept_date, LocalDate arrival_date, LocalTime dept_time, LocalTime arrival_time, Integer b_seats,
			Integer e_seats, Double b_price, Double e_price, Vendor vendor) {
		super();
		this.id = id;
		this.flight_name = flight_name;
		this.flight_number = flight_number;
		this.source = source;
		this.destination = destination;
		this.dept_date = dept_date;
		this.arrival_date = arrival_date;
		this.dept_time = dept_time;
		this.arrival_time = arrival_time;
		this.b_seats = b_seats;
		this.e_seats = e_seats;
		this.b_price = b_price;
		this.e_price = e_price;
		this.vendor = vendor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

	public String getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getDept_date() {
		return dept_date;
	}

	public void setDept_date(LocalDate dept_date) {
		this.dept_date = dept_date;
	}

	public LocalDate getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(LocalDate arrival_date) {
		this.arrival_date = arrival_date;
	}

	public LocalTime getDept_time() {
		return dept_time;
	}

	public void setDept_time(LocalTime dept_time) {
		this.dept_time = dept_time;
	}

	public LocalTime getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(LocalTime arrival_time) {
		this.arrival_time = arrival_time;
	}

	public Integer getB_seats() {
		return b_seats;
	}

	public void setB_seats(Integer b_seats) {
		this.b_seats = b_seats;
	}

	public Integer getE_seats() {
		return e_seats;
	}

	public void setE_seats(Integer e_seats) {
		this.e_seats = e_seats;
	}

	public Double getB_price() {
		return b_price;
	}

	public void setB_price(Double b_price) {
		this.b_price = b_price;
	}

	public Double getE_price() {
		return e_price;
	}

	public void setE_price(Double e_price) {
		this.e_price = e_price;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flight_name=" + flight_name + ", flight_number=" + flight_number + ", source="
				+ source + ", destination=" + destination + ", dept_date=" + dept_date + ", arrival_date="
				+ arrival_date + ", dept_time=" + dept_time + ", arrival_time=" + arrival_time + ", b_seats=" + b_seats
				+ ", e_seats=" + e_seats + ", b_price=" + b_price + ", e_price=" + e_price + ", vendor=" + vendor + "]";
	}

	
}
