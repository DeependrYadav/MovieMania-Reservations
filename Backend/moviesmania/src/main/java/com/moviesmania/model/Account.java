package com.moviesmania.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Account {

	@Id
	private String email;
	
	@NotBlank(message = "Please provide the password")
	@Size(min = 8,message = "Password size more then 8 Character")
	private String password;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private AccountStatus status = AccountStatus.ACTIVE;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Role role;

	public Account(String email,
			@NotBlank(message = "Please provide the password") @Size(min = 8, message = "Password size more then 8 Character") String password,
			@NotBlank Role role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}
}
