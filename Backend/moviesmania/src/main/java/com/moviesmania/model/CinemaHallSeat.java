package com.moviesmania.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaHallSeat {

	@NotBlank(message = "Provide Seat name.")
	public String seatName;
	
	private boolean isReserved;
	@NotNull(message = "Provide price of seat.")
	private Double price;
	
	@Enumerated(EnumType.STRING)
	private SeatType seatType;
}
