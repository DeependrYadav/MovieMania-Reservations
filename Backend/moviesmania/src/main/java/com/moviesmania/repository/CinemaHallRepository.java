package com.moviesmania.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviesmania.model.CinemaHall;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Integer> {

}
