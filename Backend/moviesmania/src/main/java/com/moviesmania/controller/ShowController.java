package com.moviesmania.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviesmania.model.MovieShow;
import com.moviesmania.service.ShowService;

import jakarta.validation.Valid;

@RestController
public class ShowController {

	@Autowired
	private ShowService ss;
	
	@PostMapping("/addShow/{movieId}/{cinemaHallId}")
	public ResponseEntity<MovieShow> addShow(@PathVariable Integer movieId,@PathVariable Integer cinemaHallId,@RequestBody @Valid MovieShow show){
		return new ResponseEntity<MovieShow>(ss.addShow(movieId,cinemaHallId,show),HttpStatus.CREATED);
	}
	
	@PutMapping("/mordifyShow/{movieId}/{cinemaHallId}/{show_id}")
	public ResponseEntity<MovieShow> mordifyShow(@PathVariable Integer movieId,@PathVariable Integer cinemaHallId,
			@PathVariable Integer show_id,@RequestBody @Valid MovieShow show){
		return new ResponseEntity<MovieShow>(ss.mordifyShow(movieId,cinemaHallId,show_id,show),HttpStatus.CREATED);
	}
	
	@GetMapping("/viewShow")
	public ResponseEntity<List<MovieShow>> viewAllShow(){
		return new ResponseEntity<List<MovieShow>>(ss.viewAllShow(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewShowByDate/{date}")
	public ResponseEntity<List<MovieShow>> viewShowByDate(@PathVariable LocalDate date){
		return new ResponseEntity<List<MovieShow>>(ss.viewShowByDate(date),HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewShowByCity/{city}")
	public ResponseEntity<List<MovieShow>> viewShowByCity(@PathVariable String city){
		return new ResponseEntity<List<MovieShow>>(ss.viewShowByCity(city),HttpStatus.ACCEPTED);
	}
}
