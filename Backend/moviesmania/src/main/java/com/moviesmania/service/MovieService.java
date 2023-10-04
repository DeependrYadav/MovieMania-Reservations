package com.moviesmania.service;

import java.util.List;

import com.moviesmania.model.Movie;

public interface MovieService {

	public Movie addMovie(Movie movie);

	public Movie mordifyMovie(Integer movieId,Movie movie);

	public List<Movie> searchMovie(String text);
}
