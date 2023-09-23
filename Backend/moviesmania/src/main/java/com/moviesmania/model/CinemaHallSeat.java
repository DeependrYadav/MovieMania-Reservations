package com.moviesmania.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CinemaHallSeat {

	public String seatName;
	private boolean isReserved;
	private Double price;
	private SeatType seatType;
}
