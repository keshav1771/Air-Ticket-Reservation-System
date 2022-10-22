package com.flightbackend.api.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="flight_booking")
public class CustomerFlight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Customer customer;
	
	@OneToOne
	private Flight flight;
	
	@OneToOne
	private Vendor vendor;
	
	private String seat_type;
	private Integer no_of_seats;
	private String booking_number;
	private LocalDateTime booking_date;
	private Double total_amount;
	private String status;
	
	public CustomerFlight() {
		
	}

	public CustomerFlight(Long id, Customer customer, Flight flight, Vendor vendor, String seat_type,
			Integer no_of_seats, String booking_number, LocalDateTime booking_date, Double total_amount,
			String status) {
		super();
		this.id = id;
		this.customer = customer;
		this.flight = flight;
		this.vendor = vendor;
		this.seat_type = seat_type;
		this.no_of_seats = no_of_seats;
		this.booking_number = booking_number;
		this.booking_date = booking_date;
		this.total_amount = total_amount;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getSeat_type() {
		return seat_type;
	}

	public void setSeat_type(String seat_type) {
		this.seat_type = seat_type;
	}

	public Integer getNo_of_seats() {
		return no_of_seats;
	}

	public void setNo_of_seats(Integer no_of_seats) {
		this.no_of_seats = no_of_seats;
	}

	public String getBooking_number() {
		return booking_number;
	}

	public void setBooking_number(String booking_number) {
		this.booking_number = booking_number;
	}

	public LocalDateTime getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(LocalDateTime booking_date) {
		this.booking_date = booking_date;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomerFlight [id=" + id + ", customer=" + customer + ", flight=" + flight + ", vendor=" + vendor
				+ ", seat_type=" + seat_type + ", no_of_seats=" + no_of_seats + ", booking_number=" + booking_number
				+ ", booking_date=" + booking_date + ", total_amount=" + total_amount + ", status=" + status + "]";
	}
	
}
