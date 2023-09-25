package com.moviesmania.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.Cinema;
import com.moviesmania.repository.CinemaRepository;

import jakarta.validation.Valid;

@Service
public class CinemaServiceImpl implements CinemaService{

	@Autowired
	private CinemaRepository cr;
	
	@Override
	public Cinema addCinema(@Valid Cinema cinema) {
		if(cinema == null)throw new MoviesManiaException("Cinema is null.");
		return cr.save(cinema);
	}
}
