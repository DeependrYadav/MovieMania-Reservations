package com.moviesmania.service;

import java.util.List;

import com.moviesmania.model.Payment;

public interface PaymentService {

	Payment payTicketPrice(String email, Double amount);

	List<Payment> viewAllPayment();

}
