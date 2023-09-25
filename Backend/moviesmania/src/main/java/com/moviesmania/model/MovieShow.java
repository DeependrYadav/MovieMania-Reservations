package com.moviesmania.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MovieShow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer showId;
	
	@NotNull(message = "Provide show Date.")
	private LocalDate date;
	
	@NotNull(message = "Provide show Starting time.")
	private LocalTime startTime;

	@NotNull(message = "Provide show Ending time.")
	private LocalTime endTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Movie movie;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CinemaHall cinemaHall;

	public MovieShow(@NotBlank(message = "Provide show Date.") LocalDate date,
			@NotBlank(message = "Provide show Starting time.") LocalTime startTime,
			@NotBlank(message = "Provide show Ending time.") LocalTime endTime, Movie movie) {
		super();
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.movie = movie;
	}
}
