package com.moviesmania.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moviesmania.model.Booking;
import com.moviesmania.service.BookingService;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bs;

	@PostMapping("/user/createBooking/{email}/{showId}/{paymentId}")
	public ResponseEntity<Booking> createBooking(@PathVariable String email,@PathVariable Integer showId,
			@PathVariable Integer paymentId, @RequestParam List<String> seats){
		return new ResponseEntity<Booking>(bs.createBooking(email,showId,paymentId,seats),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user/getAllBooking")
	public ResponseEntity<List<Booking>> getAllBookings(){
		return new ResponseEntity<List<Booking>>(new ArrayList<>(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user/getBookingById/{bookingId}")
	public ResponseEntity<Booking> createBooking(@PathVariable Integer bookingId){
		return new ResponseEntity<Booking>(bs.getBookingById(bookingId),HttpStatus.ACCEPTED);
	}
	
}
