package com.moviesmania.service;

import java.util.List;

import com.moviesmania.model.MovieShow;

import jakarta.validation.Valid;

public interface ShowService {

	MovieShow addShow(Integer movieId,Integer cinemaHallId,@Valid MovieShow show);

	MovieShow mordifyShow(Integer movieId, Integer cinemaHallId, Integer show_id,@Valid MovieShow show);

	List<MovieShow> viewAllShow();

}
