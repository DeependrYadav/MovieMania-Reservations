package com.moviesmania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviesmania.model.User;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/signin")
	public ResponseEntity<User> addUser(@RequestBody @Valid User user){
		user.getAccount().setPassword(passwordEncoder.encode(user.getAccount().getPassword()));
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
}
