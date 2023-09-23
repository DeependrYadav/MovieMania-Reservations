package com.moviesmania.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	
	private Integer numberOfSeats;
	
	private LocalDateTime bookingTime = LocalDateTime.now();
	
	private BookingStatus bookingStatus;
	
	@OneToOne
	private Show show;

	@OneToOne
	private Payment payment;

	public Booking(Integer numberOfSeats, LocalDateTime bookingTime, BookingStatus bookingStatus, Show show,
			Payment payment) {
		super();
		this.numberOfSeats = numberOfSeats;
		this.bookingTime = bookingTime;
		this.bookingStatus = bookingStatus;
		this.show = show;
		this.payment = payment;
	}
	
	
}
