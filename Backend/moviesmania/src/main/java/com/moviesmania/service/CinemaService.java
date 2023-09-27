package com.moviesmania.service;

import java.util.List;

import com.moviesmania.model.Cinema;

import jakarta.validation.Valid;

public interface CinemaService {

	Cinema addCinema(@Valid Cinema cinema);

	List<Cinema> viewAllCinema(Integer pagination, Integer records, String sortBy, String direction);

}
