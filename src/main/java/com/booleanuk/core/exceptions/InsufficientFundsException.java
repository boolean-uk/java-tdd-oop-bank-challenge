package com.booleanuk.core.exceptions;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("Insufficient funds.");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
