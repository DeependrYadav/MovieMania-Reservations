package com.moviesmania.service;

import com.moviesmania.model.Payment;

public interface PaymentService {

	Payment payTicketPrice(String email, Double amount);

}
