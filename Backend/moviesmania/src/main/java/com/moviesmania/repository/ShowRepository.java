package com.moviesmania.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviesmania.model.MovieShow;

public interface ShowRepository extends JpaRepository<MovieShow, Integer> {

}
