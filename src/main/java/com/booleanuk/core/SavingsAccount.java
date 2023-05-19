package com.booleanuk.core;

public class SavingsAccount extends Account {

    private SavingsAccount(String branch) {
        super(branch);
    }

    public static SavingsAccount create(String branch) {
        SavingsAccount account = new SavingsAccount(branch);
        accounts.add(account);
        return account;
    }
}
