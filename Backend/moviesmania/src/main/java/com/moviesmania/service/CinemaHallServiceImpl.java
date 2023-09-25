package com.moviesmania.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.Cinema;
import com.moviesmania.model.CinemaHall;
import com.moviesmania.repository.CinemaHallRepository;
import com.moviesmania.repository.CinemaRepository;

import jakarta.validation.Valid;

@Service
public class CinemaHallServiceImpl implements CinemaHallService{

	@Autowired
	private CinemaHallRepository chr;

	@Autowired
	private CinemaRepository cr;
	@Override
	public @Valid CinemaHall addCinemaHall(Integer cinemaId, @Valid CinemaHall cinemaHall) {
		Cinema cinema = cr.findById(cinemaId).orElseThrow(()-> new MoviesManiaException("Invalid Cinema ID."));
		if(cinemaHall == null)throw new MoviesManiaException("Cinema Hall is null.");
		cinemaHall.setCinema(cinema);
		cinema.getCinemaHallList().add(cinemaHall);
		return chr.save(cinemaHall);
	}

}
