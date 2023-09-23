package com.moviesmania.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class City {

	@Id
	private String zipCode;
	
	@NotBlank(message = "Please privide city name.")
	private String cityName;
	
	@NotBlank(message = "Please privide state name.")
	private String state;
	
	@OneToMany(mappedBy = "cinema")
	private List<Cinema> cinemaList = new ArrayList<>();

	public City(String zipCode, @NotBlank(message = "Please privide city name.") String cityName,
			@NotBlank(message = "Please privide state name.") String state) {
		super();
		this.zipCode = zipCode;
		this.cityName = cityName;
		this.state = state;
	}
}
