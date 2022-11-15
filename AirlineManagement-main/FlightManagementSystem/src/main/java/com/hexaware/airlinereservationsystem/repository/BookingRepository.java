package com.hexaware.airlinereservationsystem.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.airlinereservationsystem.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	@Query(value = "Select * from booking_table where user_id=?1", nativeQuery = true )
	public List<Booking> getBookingByUserId(int userId);
	public List<Booking> findBookingByBookingDate(String bookDate);
	
	@Transactional
	@Modifying
	@Query(value="delete from booking_table where booking_id=?1", nativeQuery = true)
	public void deleteBooking(int BookingId);
}
