package com.moviesmania.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Users")
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
	
	@NotBlank(message = "Please provide the password")
	@Size(min = 8,message = "Password size more then 8 Character")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private AccountStatus status = AccountStatus.ACTIVE;
	
	@NotNull(message = "Provide user Role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Embedded
	private Address address;
	
//	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//	private List<Booking> bookings = new ArrayList<>();
	

	public User(@NotBlank(message = "Name can not be null or empty.") String name,
			@Email(message = "Provide email in valid format.") String email, @NotBlank String phone,
			@NotBlank(message = "Please provide the password") @Size(min = 8, message = "Password size more then 8 Character") String password,
			@NotBlank AccountStatus status, @NotBlank Role role, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.status = status;
		this.role = role;
		this.address = address;
	}
}
