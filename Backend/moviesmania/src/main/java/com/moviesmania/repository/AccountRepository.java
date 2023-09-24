package com.moviesmania.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviesmania.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
