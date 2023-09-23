package com.moviesmania.model;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer movieId;
	@NotBlank(message = "Please provide movie title.")
	private String title;
	
	@NotBlank(message = "Please provide movie descritpion.")
	private String description;
	
	@NotBlank(message = "Please provide movie Duration.")
	private Integer durationInMins;
	
	@NotBlank(message = "Please provide movie Language.")
	private String language;
	
	@NotBlank(message = "Please provide movie Release date.")
	private LocalDate releaseDate;
	
	@NotBlank(message = "Please provide movie Genre.")
	private String genre;
	
	@OneToMany(mappedBy = "movie")
	private List<Show> showsList;
	
}