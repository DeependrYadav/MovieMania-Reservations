package com.moviesmania.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.User;
import com.moviesmania.repository.UserRepository;

import jakarta.validation.Valid;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository ur;
	
	@Override
	public User addUser(@Valid User user) {
		if(user == null)throw new MoviesManiaException("User is null.");
		return ur.save(user);
	}

	@Override
	public User findByEmail(String name) {
		return ur.findByEmail(name).orElseThrow(() -> new MoviesManiaException("Invalid email"));
	}

}
