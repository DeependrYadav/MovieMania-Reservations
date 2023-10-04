package com.moviesmania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.moviesmania.model.Payment;
import com.moviesmania.service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService ps;
	
	@PostMapping("/pay/{email}/{amount}")
	public ResponseEntity<Payment> payTicketPrice(@PathVariable String email,@PathVariable Double amount){
		return new ResponseEntity<Payment>(ps.payTicketPrice(email,amount),HttpStatus.ACCEPTED);
	}
}
