package com.booleanuk.core;

public class CurrentAccount extends Account{

    private String accountType;
    public CurrentAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
        this.accountType = "current";
    }
}
