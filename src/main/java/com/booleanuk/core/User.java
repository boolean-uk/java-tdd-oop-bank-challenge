package com.booleanuk.core;

import java.util.ArrayList;

public class User {
    private int userId;
    private String name;
    private ArrayList<Account> accounts;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public int createAccount(String accountType) {
        if (accountType.equals("Current")) {
            CurrentAccount newAccount = new CurrentAccount(this);
            this.accounts.add(newAccount);
            return newAccount.getAccountNumber();
        }
        SavingsAccount newAccount = new SavingsAccount(this);
        this.accounts.add(newAccount);
        return newAccount.getAccountNumber();
    }
}
