package com.moviesmania.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Account {

	@Id
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String status;
	
}
