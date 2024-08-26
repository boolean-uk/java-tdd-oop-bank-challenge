package com.booleanuk.core;

public abstract class Account {

    private final String accountNumber;

    public Account(String accNumber) {
        this.accountNumber = accNumber;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

}
