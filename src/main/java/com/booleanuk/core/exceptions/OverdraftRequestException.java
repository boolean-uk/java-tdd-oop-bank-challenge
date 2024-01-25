package com.booleanuk.core.exceptions;

public class OverdraftRequestException extends Exception {
    public OverdraftRequestException() {
        super("Overdraft request not approved.");
    }

    public OverdraftRequestException(String message) {
        super(message);
    }
}
