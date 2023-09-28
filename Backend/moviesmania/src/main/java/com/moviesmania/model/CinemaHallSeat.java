package com.moviesmania.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CinemaHallSeat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer seatId;
	
	@NotBlank(message = "Provide Seat name.")
	public String seatName;
	
	private boolean isReserved;
	
	@NotNull(message = "Provide price of seat.")
	private Double price;
	
	@Enumerated(EnumType.STRING)
	private SeatType seatType;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private CinemaHall cinemaHall;

	public CinemaHallSeat(@NotBlank(message = "Provide Seat name.") String seatName, boolean isReserved,
			@NotNull(message = "Provide price of seat.") Double price, SeatType seatType, CinemaHall cinemaHall) {
		super();
		this.seatName = seatName;
		this.isReserved = isReserved;
		this.price = price;
		this.seatType = seatType;
		this.cinemaHall = cinemaHall;
	}
	
	
}
