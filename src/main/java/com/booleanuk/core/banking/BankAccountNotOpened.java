package com.booleanuk.core.banking;

public class BankAccountNotOpened extends RuntimeException {
    public BankAccountNotOpened(String message) {
        super(message);
    }
}
