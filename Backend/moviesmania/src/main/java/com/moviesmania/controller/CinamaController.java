package com.moviesmania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviesmania.model.Cinema;
import com.moviesmania.service.CinemaService;

import jakarta.validation.Valid;

@RestController
public class CinamaController {

	@Autowired
	private CinemaService cs;
	
	@PostMapping("/addCinema")
	public ResponseEntity<Cinema> addCinema(@RequestBody @Valid Cinema cinema){
		return new ResponseEntity<Cinema>(cs.addCinema(cinema),HttpStatus.CREATED);
	}
}
