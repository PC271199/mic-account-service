package com.example.account_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.account_service.DTO.AccountDto;
import com.example.account_service.entities.Account;
import com.example.account_service.mapstruct.AccountMapper;

import com.example.account_service.mapstruct.UserMapper;
import com.example.account_service.services.AccountService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-account")
public class AccountController {
	  @Autowired
	  private AccountMapper accmap;
	  @Autowired
	  private UserMapper usermap;
	  @Autowired
	  private AccountService accser;
	  
	  @RequestMapping(value = "/accounts", method = RequestMethod.GET)
	  public ResponseEntity<List<AccountDto>> getAll() {
		  return  ResponseEntity.ok(this.accmap.toAccountDTOs(this.accser.findAll()));
	  }
	  @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
	  public ResponseEntity<AccountDto> getById(@PathVariable int id) {
		  if(accser.findById(id)!=null) {
			    System.out.println("Value found - " + accser.findById(id).getUsername());
		  }
		  System.out.println(this.accser.findById(id).getUser().getId());
	    return ResponseEntity.ok(this.accmap.toAccountDTO(this.accser.findById(id)));
	  }
	  @RequestMapping(value = "/accounts", method = RequestMethod.POST)
	  public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
		  System.out.println(accountDto.getUserDto().getId()+"kkkkkkkkkkkkkkkkk");
//		  System.out.println(this.accmap.toAccountEntity(accountDto).getUser().getId()+"nnnnnnnnnnnnnnnnnnnnnnnnnnn");
		  Account result=accser.add(this.accmap.toAccountEntity(accountDto));
	      return new ResponseEntity<AccountDto>(this.accmap.toAccountDTO(result), HttpStatus.CREATED);
	  }
	  @RequestMapping(value = "/accounts", method = RequestMethod.PUT)
	  public ResponseEntity<AccountDto> editAccount(@RequestBody AccountDto accountDto) {
		  Account result=accser.edit(this.accmap.toAccountEntity(accountDto));
	      return new ResponseEntity<AccountDto>(this.accmap.toAccountDTO(result), HttpStatus.OK);
	  }
	  @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
	  public ResponseEntity<Object> deleteById(@PathVariable int accountId) {
		  accser.delete(accountId);
		  return  new ResponseEntity<Object>("Delete successfully account with id: " + accountId, HttpStatus.OK);
	  }
}
