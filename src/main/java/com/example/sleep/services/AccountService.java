package com.example.sleep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sleep.entities.Account;
import com.example.sleep.repositories.AccountRepository;
import com.example.sleep.repositories.UserRepository;


@Service
public class AccountService {
	@Autowired
	private AccountRepository accrepo;
	@Autowired
	private UserRepository userrepo;
	public Account changeAccount(Account oldaccount,Account newaccount) {
//		oldaccount.setUsername(newaccount.getUsername());
//		oldaccount.setPassword(newaccount.getPassword());
//		accrepo.save(oldaccount);
//		
//		User thisuser=this.userrepo.findByAccountId(oldaccount.getId());
//		thisuser.setName(newaccount.getUser().getName());
//		thisuser.setAddress(newaccount.getUser().getAddress());
//		thisuser.setAge(newaccount.getUser().getAge());
//		thisuser.setEmail(newaccount.getUser().getEmail());
//		thisuser.setAccount(oldaccount);
//		userrepo.save(thisuser);
//		
//		return oldaccount;
		oldaccount.setUsername(newaccount.getUsername());
		oldaccount.setPassword(newaccount.getPassword());
		oldaccount.getUser().setName(newaccount.getUser().getName());
		oldaccount.getUser().setAddress(newaccount.getUser().getAddress());
		oldaccount.getUser().setAge(newaccount.getUser().getAge());
		oldaccount.getUser().setEmail(newaccount.getUser().getEmail());
		accrepo.save(oldaccount);
		return oldaccount;
	}
	public List<Account> findAll(){
		return accrepo.findAll();
	}
	public Account findById(int accountId) {
		Account result=accrepo.findById(accountId).orElseThrow();
		return result;
	}
	public Account add(Account account) {
		Optional<Account> accountEntityFromDataBase = this.accrepo.findByUsername(account.getUsername());
        if (accountEntityFromDataBase.isPresent()) {
            return null;
        }
        account.getUser().setAccount(account);
        
		Account thisaccount=accrepo.save(account);
//		System.out.println(thisaccount.getId()+" "+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//		User thisuser=account.getUser();
//		thisuser.setAccount(thisaccount);
//		System.out.println(thisuser.getAccount().getId()+" "+"bbbbbbbbbbbbbbbbbbbbbbbbbb");
//		userrepo.save(thisuser);
		return thisaccount;
	}
	public Account findbyUsername(String username) {
		return accrepo.findByUsername(username).get();
	}
	public Account edit(Account account) {
		Optional<Account> oldaccount = this.accrepo.findById(account.getId());
        if (!oldaccount.isPresent()) {
            return null;
        }
        Account thisaccount=oldaccount.get();
        return this.changeAccount(thisaccount, account);
	}
	
	public void delete(int accountId) {
		if (!this.accrepo.existsById(accountId)) {
            return;
        }
        this.accrepo.deleteById(accountId);
	}
	
}
