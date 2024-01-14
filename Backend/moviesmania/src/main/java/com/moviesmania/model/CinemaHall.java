package com.moviesmania.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "cinemaHall")
	@JsonManagedReference(value = "cinema-hall-reference")
	private List<MovieShow> show = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "cinemaHall",cascade = CascadeType.PERSIST)
	private List<CinemaHallSeat> hallSeats = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	private Cinema cinema;

	public CinemaHall(Integer totalSeats, Integer seatsPerRow, Integer seatsPerColumn,
			Cinema cinema) {
		super();
		this.totalSeats = totalSeats;
		this.seatsPerRow = seatsPerRow;
		this.seatsPerColumn = seatsPerColumn;
		this.cinema = cinema;
	}
}
