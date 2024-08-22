package com.booleanuk.core;

import java.util.UUID;

public class Account {
    String accountNumber;

    public Account(){
        this.accountNumber = UUID.randomUUID().toString();
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
