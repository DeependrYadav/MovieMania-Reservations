package com.moviesmania.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.User;
import com.moviesmania.repository.UserRepository;

@Service
public class UserUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository ar;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = ar.findByEmail(username).orElseThrow(() -> new MoviesManiaException("Invalid email"));
		
		List<GrantedAuthority> authorities= new ArrayList<>();
		
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority("Role_"+user.getRole());
		authorities.add(sga);
		
		
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}

}