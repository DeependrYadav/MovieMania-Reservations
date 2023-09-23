package com.moviesmania.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer showId;
	
	private LocalDate date;
	
	private LocalTime startTime;

	private LocalTime endTime;
}
