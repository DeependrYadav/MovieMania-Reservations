package com.moviesmania.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.User;
import com.moviesmania.repository.PaymentRepository;
import com.moviesmania.repository.ShowRepository;
import com.moviesmania.repository.UserRepository;

import jakarta.validation.Valid;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
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

	@Override
	public String resetPassword(String email, String oldPassword, String newPassword) {
		User user = findByEmail(email);
		
		if(newPassword.length()<8)throw new MoviesManiaException("Password size more then 8 Character");
		
		if(passwordEncoder.matches(oldPassword, user.getPassword())) {
			user.setPassword(passwordEncoder.encode(newPassword));
		}else throw new MoviesManiaException("Invalid password");
		
		return "Update successfull";
	}

	@Override
	public List<User> viewAllUser() {
		return ur.findAll();
	}

}
