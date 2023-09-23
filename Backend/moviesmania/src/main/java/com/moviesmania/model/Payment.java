package com.moviesmania.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	
	@NotBlank
	private Double amount;
	
	@NotBlank
	private LocalDateTime paymentTime;
	
	@NotBlank
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	public Payment(@NotBlank Double amount, @NotBlank PaymentStatus status) {
		super();
		this.amount = amount;
		this.paymentTime = LocalDateTime.now();
		this.status = status;
	}
}
