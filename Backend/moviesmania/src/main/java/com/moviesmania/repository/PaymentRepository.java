package com.moviesmania.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviesmania.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
