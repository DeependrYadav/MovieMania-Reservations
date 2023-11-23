package com.moviesmania.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	
	@NotNull
	@ManyToOne
	private User user;
	
	@NotNull(message = "Amount can't be null.")
	private Double amount;
	
	@NotNull(message = "Date and time can't be null.")
	private LocalDateTime paymentTime;//YYYY/MM/DD
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	public Payment(@NotBlank Double amount, @NotBlank PaymentStatus status) {
		super();
		this.amount = amount;
		this.paymentTime = LocalDateTime.now();
		this.status = status;
	}
}
