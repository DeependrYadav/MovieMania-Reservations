package com.moviesmania.service;

import com.moviesmania.model.User;

import jakarta.validation.Valid;

public interface UserService {

	User addUser(@Valid User user);

	User findByEmail(String name);
	
}
