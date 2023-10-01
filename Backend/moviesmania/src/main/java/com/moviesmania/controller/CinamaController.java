package com.moviesmania.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/cinema")
	public ResponseEntity<List<Cinema>> viewAllCinema(
			@RequestParam(required = false) Integer pagination,
			@RequestParam(required = false) Integer records,
			@RequestParam(required = false) String sortBy,
			@RequestParam(required = false) String direction){
		
		return new ResponseEntity<List<Cinema>>(cs.viewAllCinema(pagination,records,sortBy,direction),HttpStatus.ACCEPTED);
	}
}
