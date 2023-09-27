package com.moviesmania.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.Cinema;
import com.moviesmania.model.CinemaHall;
import com.moviesmania.model.CinemaHallSeat;
import com.moviesmania.model.SeatType;
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
		
			for(int i = 0; i < cinemaHall.getSeatsPerRow(); i++) {
				for(int j = 0; j < cinemaHall.getSeatsPerColumn(); j++) {
					if(i <= cinemaHall.getSeatsPerColumn()/3) {
						cinemaHall.getHallSeats().add(new CinemaHallSeat("S"+i+j, false,130.00,SeatType.REGULAR,cinemaHall));
					}else if(i <= cinemaHall.getSeatsPerColumn()/3*2) {
						cinemaHall.getHallSeats().add(new CinemaHallSeat("S"+i+j, false,150.00,SeatType.PREMIMUM,cinemaHall));					
					}else if(i < cinemaHall.getSeatsPerColumn() && j < cinemaHall.getSeatsPerColumn()/2) {
						cinemaHall.getHallSeats().add(new CinemaHallSeat("S"+i+j, false,200.00,SeatType.LEFT_BALCONEY,cinemaHall));					
					}else if(i < cinemaHall.getSeatsPerColumn() && j > cinemaHall.getSeatsPerColumn()/2) {
						cinemaHall.getHallSeats().add(new CinemaHallSeat("S"+i+j, false,200.00,SeatType.RIGHT_BALCONEY,cinemaHall));					
					}
				}
			}
		
		
		return chr.save(cinemaHall);
	}

}
