package com.moviesmania.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer movieId;
	
	private String title;
	
	private String description;
	
	private Integer durationInMins;
	
	private String language;
	
	private LocalDate releaseDate;
	
	private String country;
	
	private String genre;
	
	@ManyToOne
	private List<Show> showsList;
	
}
