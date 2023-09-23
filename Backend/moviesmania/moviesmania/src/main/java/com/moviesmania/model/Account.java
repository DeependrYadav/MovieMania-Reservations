package com.moviesmania.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Account {

	@Id
	private String email;
	
	@NotBlank(message = "Please provide the password")
	@Size(min = 8,message = "Password size more then 8 Character")
	private String password;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private AccountStatus status;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Role role;
	
}
