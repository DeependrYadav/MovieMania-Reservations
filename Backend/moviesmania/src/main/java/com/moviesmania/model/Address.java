package com.moviesmania.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Address {

	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	
	public Address(String streetAddress, String city, String state, String zipCode, String country) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}
}
