package com.moviesmania.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviesmania.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
