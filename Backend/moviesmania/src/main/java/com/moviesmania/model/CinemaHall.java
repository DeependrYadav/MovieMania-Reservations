package com.moviesmania.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CinemaHall {

	@Id
	private Integer cinemaHallId;
	
	private Integer totalSeats;
	
	private Show show;
	
	
	
	@ManyToOne
	private Cinema cinema;
}
