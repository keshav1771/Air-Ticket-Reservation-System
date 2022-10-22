package com.flightbackend.api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SourceDestDeptdto {
	private String source;
	private String destination;
	private LocalDate dept_date;
	
	public SourceDestDeptdto() {
		
	}

	public SourceDestDeptdto(String source, String destination, LocalDate dept_date) {
		super();
		this.source = source;
		this.destination = destination;
		this.dept_date = dept_date;
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

	@Override
	public String toString() {
		return "SourceDestDeptdto [source=" + source + ", destination=" + destination + ", dept_date=" + dept_date
				+ "]";
	}
	
}
