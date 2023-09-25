package com.moviesmania.service;

import com.moviesmania.model.Cinema;

import jakarta.validation.Valid;

public interface CinemaService {

	Cinema addCinema(@Valid Cinema cinema);

}
