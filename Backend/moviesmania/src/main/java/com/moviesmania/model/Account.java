package com.moviesmania.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
