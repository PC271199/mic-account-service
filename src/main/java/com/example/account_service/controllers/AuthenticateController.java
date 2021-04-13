package com.example.account_service.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.account_service.DTO.AccountDto;
import com.example.account_service.DTO.LoginDto;
import com.example.account_service.DTO.RegisterDto;
import com.example.account_service.config.AuthToken;
import com.example.account_service.config.JwtTokenUtil;
import com.example.account_service.entities.Account;
import com.example.account_service.mapstruct.AccountMapper;
import com.example.account_service.mapstruct.RegisterMapper;
import com.example.account_service.services.AccountService;


@RestController
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private AccountMapper accmap;
	@Autowired
	private AccountService accser;
	@Autowired
	private RegisterMapper registermap;
	@PostMapping("auth/login")
	public ResponseEntity<AuthToken> login(@RequestBody LoginDto loginDto) throws AuthenticationException {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		System.out.println(loginDto.getUsername()+ loginDto.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(authentication);
		return ResponseEntity.ok(new AuthToken(token));
	}
	@PostMapping("auth/register")
    public ResponseEntity<AccountDto> register(@RequestBody RegisterDto registerDto) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println(registermap.toAccountEntity(registerDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.accmap.toAccountDTO(this.accser.add(
                        this.registermap.toAccountEntity(registerDto))));
    }
}

