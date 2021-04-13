package com.example.account_service.exception;

public class AccountIsExistsException extends RuntimeException {
    public AccountIsExistsException(int id) {
        super("User is exist with id: " + id);
    }
}
