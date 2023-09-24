package com.moviesmania.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
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
	
	@NotNull(message = "Provide show details.")
	@ManyToOne
	private MovieShow show;
	
	@ElementCollection
//	@Embedded
	private List<CinemaHallSeat> hallSeats = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cinema cinema;

	public CinemaHall(Integer totalSeats, Integer seatsPerRow, Integer seatsPerColumn, MovieShow show,
			Cinema cinema) {
		super();
		this.totalSeats = totalSeats;
		this.seatsPerRow = seatsPerRow;
		this.seatsPerColumn = seatsPerColumn;
		this.show = show;
		this.cinema = cinema;
	}
	
	
}
