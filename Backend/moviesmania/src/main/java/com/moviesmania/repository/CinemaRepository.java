package com.moviesmania.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviesmania.model.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

}
