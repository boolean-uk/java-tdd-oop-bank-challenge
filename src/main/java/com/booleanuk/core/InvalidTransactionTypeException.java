package com.booleanuk.core;
// Figured i would try making my own exception as i've never done that before.
public class InvalidTransactionTypeException extends Exception {
    public InvalidTransactionTypeException() {
        super();
    }
    public InvalidTransactionTypeException(String message) {
        super(message);
    }


}
