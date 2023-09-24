package com.moviesmania.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	private City location;
	
	@OneToMany(mappedBy = "cinema",cascade = CascadeType.ALL)
	private List<CinemaHall> cinemaHallList = new ArrayList<>();
}
