package com.moviesmania.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.Payment;
import com.moviesmania.model.PaymentStatus;
import com.moviesmania.model.User;
import com.moviesmania.repository.PaymentRepository;
import com.moviesmania.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private UserRepository ur;
	
	@Autowired
	private PaymentRepository pr;
	
	@Override
	@Transactional
	public Payment payTicketPrice(String email,Double amount) {
		
		User user = ur.findByEmail(email).orElseThrow(()-> new MoviesManiaException("Invalid email ID:"+ email));
		
		Payment payment = new Payment();
		payment.setAmount(amount);
		payment.setStatus(PaymentStatus.PENDING);
		payment.setUser(user);
		return pr.save(payment);
	}

}
