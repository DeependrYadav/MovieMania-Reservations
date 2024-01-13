package com.moviesmania.service;

import java.util.List;

import com.moviesmania.model.User;

import jakarta.validation.Valid;

public interface UserService {

	User addUser(@Valid User user);

	User findByEmail(String name);

	String resetPassword(String email, String oldPassword, String newPassword);

	List<User> viewAllUser();
	
}
