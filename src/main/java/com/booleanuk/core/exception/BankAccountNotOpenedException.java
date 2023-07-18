package com.booleanuk.core.exception;

public class BankAccountNotOpenedException extends RuntimeException {
    public BankAccountNotOpenedException(String message) {
        super(message);
    }
}
