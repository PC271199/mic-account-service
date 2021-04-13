package com.example.account_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.account_service.entities.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "Select * from users where account_id = :accountId",nativeQuery = true)
	public User findByAccountId(@Param("accountId") int accountId);
	
	@Modifying
	@Query(value = "Delete from users where account_id = :accountId",nativeQuery = true)
	public void deleteByAccountId(@Param("accountId") int accountId);
}
