package com.moviesmania.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer movieId;
	
	@NotBlank(message = "Please provide movie title.")
	private String title;
	
	@NotBlank(message = "Please provide movie descritpion.")
	private String description;
	
	@NotNull(message = "Please provide movie Duration.")
	private Integer durationInMins;
	
	@NotBlank(message = "Please provide movie Language.")
	private String language;
	
	@NotNull(message = "Please provide movie Release date.")
	private LocalDate releaseDate;
	
	@NotBlank(message = "Please provide movie Genre.")
	private String genre;
	
	@OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
	@JsonManagedReference(value = "movie-reference")
	private List<MovieShow> showsList = new ArrayList<>();

	public Movie(@NotBlank(message = "Please provide movie title.") String title,
			@NotBlank(message = "Please provide movie descritpion.") String description,
			@NotBlank(message = "Please provide movie Duration.") Integer durationInMins,
			@NotBlank(message = "Please provide movie Language.") String language,
			@NotBlank(message = "Please provide movie Release date.") LocalDate releaseDate,
			@NotBlank(message = "Please provide movie Genre.") String genre) {
		super();
		this.title = title;
		this.description = description;
		this.durationInMins = durationInMins;
		this.language = language;
		this.releaseDate = releaseDate;
		this.genre = genre;
	}
}
