package com.booleanuk.core;

import java.util.ArrayList;

public class User {
    int userId;
    String name;
    ArrayList<Account> accounts;

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
        Account newAccount = new Account(this);
        this.accounts.add(newAccount);
        return newAccount.getAccountNumber();
    }
}
