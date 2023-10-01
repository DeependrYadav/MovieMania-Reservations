package com.moviesmania.service;

import java.util.List;

import com.moviesmania.model.CinemaHall;

import jakarta.validation.Valid;

public interface CinemaHallService {

	CinemaHall addCinemaHall(Integer cinemaId, @Valid CinemaHall cinemaHall);

	List<CinemaHall> viewCinemaHall(Integer pagination, Integer records, String sortBy, String direction);

}
