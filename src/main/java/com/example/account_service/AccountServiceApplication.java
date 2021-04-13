package com.example.account_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


import com.example.account_service.entities.Account;
import com.example.account_service.repositories.AccountRepository;

@SpringBootApplication
public class AccountServiceApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
//	@Override
//	public void run(String...args) throws Exception{
//		String sql="Insert into users (name, address, age, email, account_id) values("+"'nguyen van b', 'da nang', 20, 'pcgmail', 5)";
//		int row =jdbctemplate.update(sql);
//		if(row>0) {
//			System.out.println("ok");
//		}
//		List<Account> result=accrepo.findAll();
//		for (Account account : result) {
//			
//			System.out.println(account.getUser()==null?"aaa":account.getUser().getAddress());
//		}
//		System.out.println(result);
//	}

}
