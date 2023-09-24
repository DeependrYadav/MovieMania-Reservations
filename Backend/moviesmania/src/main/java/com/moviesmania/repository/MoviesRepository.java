package com.moviesmania.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviesmania.model.Movie;

public interface MoviesRepository extends JpaRepository<Movie, Integer>{

}
