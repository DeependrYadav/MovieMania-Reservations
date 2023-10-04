package com.moviesmania.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.Booking;
import com.moviesmania.model.CinemaHall;
import com.moviesmania.model.MovieShow;
import com.moviesmania.model.Payment;
import com.moviesmania.model.User;
import com.moviesmania.repository.PaymentRepository;
import com.moviesmania.repository.ShowRepository;
import com.moviesmania.repository.UserRepository;

import jakarta.validation.Valid;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private ShowRepository sr;
	
	@Autowired
	private PaymentRepository pr;
	
	@Override
	public User addUser(@Valid User user) {
		if(user == null)throw new MoviesManiaException("User is null.");
		return ur.save(user);
	}

	@Override
	public User findByEmail(String name) {
		return ur.findByEmail(name).orElseThrow(() -> new MoviesManiaException("Invalid email"));
	}

	@Override
	public String resetPassword(String email, String oldPassword, String newPassword) {
		User user = findByEmail(email);
		
		if(newPassword.length()<8)throw new MoviesManiaException("Password size more then 8 Character");
		
		if(passwordEncoder.matches(oldPassword, user.getPassword())) {
			user.setPassword(passwordEncoder.encode(newPassword));
		}else throw new MoviesManiaException("Invalid password");
		
		return "Update successfull";
	}

	@Override
	public Booking createBooking(String email, Integer showId,String cinemaHallSeatName,Integer paymentId) {

		User user = findByEmail(email);
		MovieShow show = sr.findById(showId).orElseThrow(()-> new MoviesManiaException("Invalid show ID."));
		
		CinemaHall cinemaHall = show.getCinemaHall();
		
		Payment payment = pr.findById(paymentId).orElseThrow(()-> new MoviesManiaException("Invalid payment ID: "+paymentId));
		
		long minutes = ChronoUnit.MINUTES.between(payment.getPaymentTime(),LocalDateTime.now());

		if(payment.getUser() == user && minutes > 5) {
			
			Booking booking = new Booking(paymentId, LocalDateTime.now(), null, show, payment, user);
			
			return null;
		}else throw new MoviesManiaException("payment Time out.");
//		Period.between(payment.getPaymentTime(),LocalDateTime.now());
	}

}
