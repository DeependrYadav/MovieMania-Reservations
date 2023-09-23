package com.moviesmania.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CinemaHall {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cinemaHallId;
	
	@NotNull(message = "Provide total seats.")
	private Integer totalSeats;
	
	@NotNull(message = "Provide total seats per row.")
	private Integer seatsPerRow;
	
	@NotNull(message = "Provide total seats per column.")
	private Integer seatsPerColumn;
	
	private Show show;
	
	private Integer[][] hallSeats = new Integer[seatsPerRow][seatsPerColumn];
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cinema cinema;

	public CinemaHall(Integer totalSeats, Integer seatsPerRow, Integer seatsPerColumn, Show show, Integer[][] hallSeats,
			Cinema cinema) {
		super();
		this.totalSeats = totalSeats;
		this.seatsPerRow = seatsPerRow;
		this.seatsPerColumn = seatsPerColumn;
		this.show = show;
		this.hallSeats = hallSeats;
		this.cinema = cinema;
	}
	
	
}
