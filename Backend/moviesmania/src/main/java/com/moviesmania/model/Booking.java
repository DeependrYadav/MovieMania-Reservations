package com.moviesmania.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingNumber;
	
	private Integer numberOfSeats;
	
	private LocalDateTime bookingTime = LocalDateTime.now();
	
	private BookingStatus bookingStatus;
	
	@OneToOne
	private Show show;

	@OneToOne
	private Payment payment;
	
}
