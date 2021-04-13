package com.example.sleep.config;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.sleep.entities.Account;
import com.example.sleep.services.AccountService;



@Component

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private AccountService accountservice;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountservice.findbyUsername(username);
		System.out.println("bbbbbbbbbbbbbbbbbbb");
		if(account == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(
				account.getUsername(), account.getPassword(), getAuthority(account));
	}

	private Set<SimpleGrantedAuthority> getAuthority(Account account) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		account.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
		});
        System.out.println("cccccccccccccccccccc");
		return authorities;
	}
}
