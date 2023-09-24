package com.moviesmania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviesmania.model.Movie;
import com.moviesmania.service.MovieService;

import jakarta.validation.Valid;

@RestController
public class MovieController {

	@Autowired
	private MovieService ms;
	
	@PostMapping("/addmovie")
	public ResponseEntity<Movie> addMovie(@RequestBody @Valid Movie movie){
		return new ResponseEntity<Movie>(ms.addMovie(movie), HttpStatus.CREATED);
	}
}
