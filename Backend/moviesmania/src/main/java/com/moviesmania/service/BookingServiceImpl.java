package com.moviesmania.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.Booking;
import com.moviesmania.model.BookingStatus;
import com.moviesmania.model.CinemaHall;
import com.moviesmania.model.CinemaHallSeat;
import com.moviesmania.model.MovieShow;
import com.moviesmania.model.Payment;
import com.moviesmania.model.PaymentStatus;
import com.moviesmania.model.User;
import com.moviesmania.repository.BookingRepository;
import com.moviesmania.repository.PaymentRepository;
import com.moviesmania.repository.ShowRepository;
import com.moviesmania.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	private UserRepository ur;
	
	@Autowired
	private ShowRepository sr;
	
	@Autowired
	private PaymentRepository pr;
	
	@Autowired
	private BookingRepository br;
	
	@Override
	@Transactional
	public Booking createBooking(String email, Integer showId, Integer paymentId, List<String> seats) {

		User user = ur.findByEmail(email).orElseThrow(()-> new MoviesManiaException("Invalid user email: "+email));
		
		MovieShow show = sr.findById(showId).orElseThrow(()-> new MoviesManiaException("Invalid show ID."));
		
		CinemaHall cinemaHall = show.getCinemaHall();
		
		Payment payment = pr.findById(paymentId).orElseThrow(()-> new MoviesManiaException("Invalid payment ID: "+paymentId));
		
		long minutes = ChronoUnit.MINUTES.between(payment.getPaymentTime(),LocalDateTime.now());

		if(payment.getUser() == user && minutes > 5) {
			
			Booking booking = new Booking( seats.size(), LocalDateTime.now(), BookingStatus.CONFIRMED, show, payment, user);
			
			for(int i = 0; i < seats.size(); i++) {
				String seatsName = seats.get(i);
				
				CinemaHallSeat cinemaHallSeat = cinemaHall.getHallSeats().stream().filter(s-> s.getSeatName().equals(seatsName)).toList().get(0);

				if(!cinemaHallSeat.isReserved())cinemaHallSeat.setReserved(true);
				
				else throw new MoviesManiaException("Seat is already reserved :"+cinemaHallSeat.getSeatName());
				
				booking.getSeats()[i] = seatsName;
			}
			
			payment.setStatus(PaymentStatus.COMPLETED);
			
			return br.save(booking);
			
		}else throw new MoviesManiaException("payment Time out.");
	}
}
