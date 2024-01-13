package com.moviesmania.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.Role;
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
		user.setRole(Role.valueOf( user.getRole().toString().toUpperCase() ));
		return new ResponseEntity<User>(us.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/signIn")
	public ResponseEntity<String> signin(Authentication auth){
		User user = us.findByEmail(auth.getName());
		if(user == null)throw new MoviesManiaException("Invalid email.com");
		return new ResponseEntity<String>(user.getName()+" successfully login",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email")String email){
		
		return new ResponseEntity<User>(us.findByEmail(email),HttpStatus.ACCEPTED);
	}
	@GetMapping("/viewAllUser")
	public ResponseEntity<List<User>> viewAllUser(){
		
		return new ResponseEntity<List<User>>(us.viewAllUser(),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/user/resetPassword/{email}")
	public ResponseEntity<String> resetPassword(@PathVariable String email, @PathVariable String oldPassword,@PathVariable String newPassword){
		return new ResponseEntity<String>(us.resetPassword(email,oldPassword,newPassword),HttpStatus.ACCEPTED);
	}
	
}
