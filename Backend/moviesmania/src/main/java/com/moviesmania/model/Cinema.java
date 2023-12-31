package com.moviesmania.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cinemaId;
	
	private String cinemaName;
	
	@Embedded
	@NotNull(message = "Provide cinema address.")
	private Address address;
	
	@OneToMany(mappedBy = "cinema",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<CinemaHall> cinemaHallList = new ArrayList<>();

	public Cinema(String cinemaName, Address address) {
		super();
		this.cinemaName = cinemaName;
		this.address = address;
	}
}
