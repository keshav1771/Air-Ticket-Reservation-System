package com.hexaware.Airlinereservationsystem.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Airport {
	@Id
	@Column(name = "airport_code")
	private String airportCode;
	@Column(name = "airport_location")
	private String airportLocation;
	@Column(name = "airport_name")
	private String airportName;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="airport_code_fk",referencedColumnName="airport_code")
	
	private List<Flight> flightList = new ArrayList<>();
	public List<Flight> getFlightList() {
		return flightList;
	}
	

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}

	public Airport(String airportName, String airportLocation, String airportCode)
	/**
	 * parameterized Constructor
	 */
	{
		this.airportName = airportName;
		this.airportLocation = airportLocation;
		this.airportCode = airportCode;
	}

	public Airport()
	
	{
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	@Override
	public String toString() {
		return "Airport{" + "airportName='" + airportName + '\'' + ", airportLocation='" + airportLocation + '\''
				+ ", airportCode='" + airportCode + '\'' + '}';
	}
}
