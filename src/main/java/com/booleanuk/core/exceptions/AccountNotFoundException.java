package com.booleanuk.core.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException() {
        super("Account not found.");
    }
}
