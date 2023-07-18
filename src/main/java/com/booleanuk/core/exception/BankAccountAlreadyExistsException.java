package com.booleanuk.core.exception;

public class BankAccountAlreadyExistsException extends RuntimeException {
    public BankAccountAlreadyExistsException(String message) {
        super(message);
    }
}
