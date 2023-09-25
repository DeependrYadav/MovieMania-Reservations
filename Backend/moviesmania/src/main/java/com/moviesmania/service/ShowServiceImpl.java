package com.moviesmania.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.Movie;
import com.moviesmania.model.MovieShow;
import com.moviesmania.repository.MoviesRepository;
import com.moviesmania.repository.ShowRepository;

import jakarta.validation.Valid;
@Service
public class ShowServiceImpl implements ShowService{

	@Autowired
	private MoviesRepository mr;
	
	@Autowired
	private ShowRepository sr;
	
	@Override
	public MovieShow addShow(Integer movieId,Integer cinemaHallId,@Valid MovieShow show) {
		
		Movie movie = mr.findById(movieId).orElseThrow(()-> new MoviesManiaException("Invalid movie ID"));
		
		if(show == null)throw new MoviesManiaException("Show is null.");
		
		show.setMovie(movie);
		movie.getShowsList().add(show);
		
		return sr.save(show);
	}

}
