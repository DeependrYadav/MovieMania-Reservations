package com.moviesmania.service;

import java.util.List;

import com.moviesmania.model.Booking;

public interface BookingService {

	Booking createBooking(String email, Integer showId, Integer paymentId, List<String> seats);
}
