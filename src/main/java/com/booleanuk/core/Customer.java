package com.booleanuk.core;

import java.util.ArrayList;

public class Customer extends User {

    private ArrayList<Account> accounts;

    public Customer(String identifier) {
        super(identifier);
        this.accounts = new ArrayList<>();

    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void createAccount(AccountType type, String identifier) {
        if (type == AccountType.CURRENT) {
            accounts.add(new CurrentAccount(identifier));
        }

        if(type == AccountType.SAVINGS) {
            accounts.add(new SavingsAccount(identifier));
        }

    }
}
