package com.hexaware.airlinereservationsystem;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hexaware.airlinereservationsystem.exception.AirportNotFoundException;
import com.hexaware.airlinereservationsystem.exception.BookingNotFoundException;
import com.hexaware.airlinereservationsystem.exception.ErrorInfo;
import com.hexaware.airlinereservationsystem.exception.FlightNotFoundException;
import com.hexaware.airlinereservationsystem.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FlightNotFoundException.class)
	public @ResponseBody ErrorInfo checkNoSuchFlightFoundExceptionInfo(FlightNotFoundException e, HttpServletRequest req) {
		 ErrorInfo info = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		 return info;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public @ResponseBody ErrorInfo checkNoSuchUserFoundExceptionInfo(UserNotFoundException e, HttpServletRequest req) {
		 ErrorInfo info = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		 return info;
	}
	
	@ExceptionHandler(AirportNotFoundException.class)
	public @ResponseBody ErrorInfo checkNoSuchAirportFoundExceptionInfo(AirportNotFoundException e, HttpServletRequest req) {
		 ErrorInfo info = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		 return info;
	}
	
	@ExceptionHandler(BookingNotFoundException.class)
	public @ResponseBody ErrorInfo checkNoSuchBookingFoundExceptionInfo(BookingNotFoundException e, HttpServletRequest req) {
		 ErrorInfo info = new ErrorInfo(LocalDateTime.now(), e.getMessage(), req.getRequestURI());
		 return info;
	}
}
