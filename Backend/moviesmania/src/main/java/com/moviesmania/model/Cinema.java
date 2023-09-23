package com.moviesmania.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cinema {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cinemaId;
	
	private String name;
	
	private City location;
	
	@OneToMany(mappedBy = "cinema",cascade = CascadeType.ALL)
	private List<CinemaHall> cinemaHallList;
}
