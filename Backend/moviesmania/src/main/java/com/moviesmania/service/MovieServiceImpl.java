package com.moviesmania.service;

import java.util.List;

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

	@Override
	public Movie mordifyMovie(Integer movieId, Movie movie) {
		if(movie == null)throw new MoviesManiaException("Movie is null");
		Movie updateMovie = mr.findById(movieId).orElseThrow(() -> new MoviesManiaException("Invalid movie ID."));
		
		if(movie.getDescription()!=null)updateMovie.setDescription(movie.getDescription());
		if(movie.getDurationInMins()!=null)updateMovie.setDurationInMins(movie.getDurationInMins());
		if(movie.getGenre()!=null)updateMovie.setGenre(movie.getGenre());
		if(movie.getLanguage()!=null)updateMovie.setLanguage(movie.getLanguage());
		if(movie.getReleaseDate()!=null)updateMovie.setReleaseDate(movie.getReleaseDate());
		if(movie.getTitle()!=null)updateMovie.setTitle(movie.getTitle());
		
		return updateMovie;
	}

	@Override
	public List<Movie> searchMovie(String text) {
		return mr.findAll().stream().filter(m -> m.getTitle().contains(text) || m.getGenre().contains(text)).toList();
	}

}
