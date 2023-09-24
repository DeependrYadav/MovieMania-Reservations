package com.moviesmania.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.moviesmania.exception.MoviesManiaException;
import com.moviesmania.model.Account;
import com.moviesmania.repository.AccountRepository;

@Service
public class UserUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepository ar;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account account = ar.findById(username).orElseThrow(() -> new MoviesManiaException("Invalid email"));
		
		List<GrantedAuthority> authorities= new ArrayList<>();
		
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority("Role_"+account.getRole());
		authorities.add(sga);
		
		
		return new User(username, account.getPassword(), authorities);
	}

}
