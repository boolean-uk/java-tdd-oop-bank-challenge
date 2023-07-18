package com.booleanuk.core.banking;

public class BankAccountAlreadyExistsException extends RuntimeException {
    public BankAccountAlreadyExistsException(String message) {
        super(message);
    }
}
