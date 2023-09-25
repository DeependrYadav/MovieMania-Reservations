package com.moviesmania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviesmania.model.CinemaHall;
import com.moviesmania.service.CinemaHallService;

import jakarta.validation.Valid;

@RestController
public class CinemaHallController {

	@Autowired
	private CinemaHallService chs;
	@PostMapping("/addCinemaHall/{cinemaId}")
	public ResponseEntity<CinemaHall> addCinema(@PathVariable Integer cinemaId,@RequestBody @Valid CinemaHall cinemaHall){
		return new ResponseEntity<CinemaHall>(chs.addCinemaHall(cinemaId,cinemaHall),HttpStatus.CREATED);
	}
}
