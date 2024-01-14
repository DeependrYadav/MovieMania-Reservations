package com.moviesmania.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	
	@ElementCollection
	private List<String> seatsList;
	
	@ManyToOne
	@JsonBackReference(value = "Booking-Reference")
	private MovieShow show;

	@OneToOne
	private Payment payment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference(value = "User-Reference")
	private User user;

	public Booking(Integer numberOfSeats, LocalDateTime bookingTime, BookingStatus bookingStatus, MovieShow show,
			Payment payment, User user) {
		super();
		this.numberOfSeats = numberOfSeats;
		this.bookingTime = bookingTime;
		this.bookingStatus = bookingStatus;
		this.show = show;
		this.payment = payment;
		this.user = user;
	}
}
