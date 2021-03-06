package com.example.sleep.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.sleep.entities.Account;



@Transactional
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Optional<Account> findByUsername(String username);
}
