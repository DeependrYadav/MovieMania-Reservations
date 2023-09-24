package com.moviesmania.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.Movie;
import com.moviesmania.repository.MoviesRepository;


@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MoviesRepository mr;
	
	@Override
	public Movie addMovie(Movie movie) {
		if(movie == null)throw new MoviesManiaException("Movie is null");
		return mr.save(movie);
	}

}
