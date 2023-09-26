package com.moviesmania.service;

import com.moviesmania.model.CinemaHall;

import jakarta.validation.Valid;

public interface CinemaHallService {

	CinemaHall addCinemaHall(Integer cinemaId, @Valid CinemaHall cinemaHall);

}
