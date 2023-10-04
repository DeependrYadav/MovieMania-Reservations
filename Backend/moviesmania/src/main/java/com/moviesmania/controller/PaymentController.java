package com.moviesmania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.moviesmania.service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService ps;
}
