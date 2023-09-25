package com.moviesmania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviesmania.model.MovieShow;
import com.moviesmania.service.ShowService;

import jakarta.validation.Valid;

@RestController
public class ShowController {

	@Autowired
	private ShowService showService;
	
	@PostMapping("/addShow/{movieId}/{cinemaHallId}")
	public ResponseEntity<MovieShow> addShow(@PathVariable Integer movieId,@PathVariable Integer cinemaHallId,@RequestBody @Valid MovieShow show){
		return new ResponseEntity<MovieShow>(showService.addShow(movieId,cinemaHallId,show),HttpStatus.CREATED);
	}
}
