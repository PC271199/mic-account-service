package com.example.sleep.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(int id) {
        super("User id not found : " + id);
    }
}
