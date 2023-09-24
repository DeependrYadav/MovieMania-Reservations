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

import com.moviesmania.model.User;
import com.moviesmania.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService us;
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody @Valid User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return new ResponseEntity<User>(us.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/signin")
	public ResponseEntity<String> signin(Authentication auth){
		User user = us.findByEmail(auth.getName());
		return new ResponseEntity<String>(user.getName()+"successfully login",HttpStatus.CREATED);
	}
}
