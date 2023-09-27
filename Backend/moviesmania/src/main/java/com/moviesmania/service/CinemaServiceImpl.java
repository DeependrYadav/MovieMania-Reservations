package com.moviesmania.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.Cinema;
import com.moviesmania.repository.CinemaRepository;

import jakarta.validation.Valid;

@Service
public class CinemaServiceImpl implements CinemaService{

	@Autowired
	private CinemaRepository cr;
	
	@Override
	public Cinema addCinema(@Valid Cinema cinema) {
		if(cinema == null)throw new MoviesManiaException("Cinema is null.");
		return cr.save(cinema);
	}

	@Override
	public List<Cinema> viewAllCinema(Integer pagination, Integer records, String sortBy, String direction) {
		Pageable pageable = null;
		Sort sort = null;
		if(pagination != null && records == null)throw new MoviesManiaException("Provide value of records per page");
		if(sortBy != null && direction == null)throw new MoviesManiaException("Provide value of sorting direction");
			
		if(pagination != null && sortBy != null) {
			sort = Sort.by((direction.equalsIgnoreCase("asc")?"ASC":"DESC"), sortBy);
			pageable = PageRequest.of(pagination, records,sort);
			return cr.findAll(pageable).toList();
		}else if(pagination != null) {
			pageable = PageRequest.of(pagination, records);
			return cr.findAll(pageable).toList();
		}else if(sortBy != null) {
			sort = Sort.by((direction.equalsIgnoreCase("asc")?"ASC":"DESC"), sortBy);
			return cr.findAll(sort);
		}
		return cr.findAll();
	}
}
