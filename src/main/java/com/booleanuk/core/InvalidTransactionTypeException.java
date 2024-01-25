package com.booleanuk.core;

public class InvalidTransactionTypeException extends Exception {
    public InvalidTransactionTypeException() {
        super();
    }
    public InvalidTransactionTypeException(String message) {
        super(message);
    }

}
