package com.moviesmania.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.CinemaHall;
import com.moviesmania.model.Movie;
import com.moviesmania.model.MovieShow;
import com.moviesmania.repository.CinemaHallRepository;
import com.moviesmania.repository.MoviesRepository;
import com.moviesmania.repository.ShowRepository;

import jakarta.validation.Valid;
@Service
public class ShowServiceImpl implements ShowService{

	@Autowired
	private MoviesRepository mr;
	
	@Autowired
	private ShowRepository sr;
	
	@Autowired
	private CinemaHallRepository chr;
	
	public boolean isCinemaHallBooked(CinemaHall ch,MovieShow show) {
		return ch.getShow().stream().anyMatch(s-> {
			if(s.getDate().equals(show.getDate())) {
				
				int startTime = s.getStartTime().getHour()-show.getStartTime().getHour();
				int endTime = s.getStartTime().getHour()-show.getEndTime().getHour();
				if((startTime < 0 && endTime > 0) || (startTime > 0 && endTime < 0) ) {
					return true;
				}
			}
			return false;
		});
	}
	
	@Override
	public MovieShow addShow(Integer movieId,Integer cinemaHallId,@Valid MovieShow show) {
		
		Movie movie = mr.findById(movieId).orElseThrow(()-> new MoviesManiaException("Invalid movie ID"));
		
		CinemaHall ch = chr.findById(cinemaHallId).orElseThrow(()-> new MoviesManiaException("Invalid Cinema Hall ID"));
		
		if(show == null)throw new MoviesManiaException("Show is null.");

		boolean check = isCinemaHallBooked(ch, show);

		
		if(!check) {			
			show.setMovie(movie);
			show.setCinemaHall(ch);
			return sr.save(show);
		}else throw new MoviesManiaException("Cinema hall already booked");
	}

	@Override
	public MovieShow mordifyShow(Integer movieId, Integer cinemaHallId, Integer show_id,@Valid MovieShow show) {
		
		Movie movie = null;
		if(movieId != null)movie = mr.findById(movieId).orElseThrow(()-> new MoviesManiaException("Invalid movie ID"));
		
		CinemaHall ch = null;
		if(cinemaHallId != null) ch = chr.findById(cinemaHallId).orElseThrow(()-> new MoviesManiaException("Invalid Cinema Hall ID"));
		
		MovieShow movieShow = sr.findById(show_id).orElseThrow(()-> new MoviesManiaException("Invalid Show ID"));
		
		if(show == null)throw new MoviesManiaException("Show is null.");
		
		boolean check = isCinemaHallBooked(ch, movieShow);
		
		if(movieId != null)show.setMovie(movie);
		if(cinemaHallId != null)show.setCinemaHall(ch);
		if(show.getDate() != null)movieShow.setDate(show.getDate());
		if(show.getStartTime() != null)movieShow.setStartTime(show.getStartTime());
		if(show.getEndTime() != null)movieShow.setEndTime(show.getEndTime());
		
		if(!check)return sr.save(movieShow);
		else throw new MoviesManiaException("Cinema hall already booked");
	}

	@Override
	public List<MovieShow> viewAllShow() {
		return sr.findAll();
	}

	@Override
	public List<MovieShow> viewShowByDate(LocalDate date) {
		return sr.findAll().stream().filter(s-> s.getDate().equals(date)).toList();
	}

}
