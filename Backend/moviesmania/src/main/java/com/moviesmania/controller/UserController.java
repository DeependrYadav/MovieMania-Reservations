package com.moviesmania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.User;
import com.moviesmania.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository ur;
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody @Valid User user){
		user.getAccount().setPassword(passwordEncoder.encode(user.getAccount().getPassword()));
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	@GetMapping("/signin")
	public ResponseEntity<String> signin(Authentication auth){
		User user = ur.findByEmail(auth.getName()).orElseThrow(() -> new MoviesManiaException("Invalid email"));
		return new ResponseEntity<String>(user.getName()+"successfully login",HttpStatus.CREATED);
	}
}
