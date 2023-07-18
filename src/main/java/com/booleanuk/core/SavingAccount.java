package com.booleanuk.core;

public class SavingAccount extends Account{

    private String accountType;
    public SavingAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
        this.accountType = "saving";
    }
}
