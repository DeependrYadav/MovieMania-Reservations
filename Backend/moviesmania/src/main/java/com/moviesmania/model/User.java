package com.moviesmania.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name can not be null or empty.")
	private String name;
	
	@Email(message = "Provide email in valid format.")
	private String email;
	
	@NotBlank
	private String phone;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "Account_Details_ID")
	private Account account;
	
	@OneToOne
	@JoinColumn(name = "Address_id")
	private Address address;

	public User(@NotBlank(message = "Name can not be null or empty.") String name,
			@Email(message = "Provide email in valid format.") String email, @NotBlank String phone,
			@NotNull Account account, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.account = account;
		this.address = address;
	}
}
