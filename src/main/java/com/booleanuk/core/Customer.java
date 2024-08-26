package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {

    private final String id;
    private ArrayList<Account> accounts;

    public Customer() {
        this.id = "";
        this.accounts = new ArrayList<>();
    }

    public Customer(String id) {
        this.id = id;
        this.accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public String getId() {
        return id;
    }

    protected void addAccount(Account newAccount) {
        this.accounts.add(newAccount);
    }

    public Account getAccount(String accountNumber) {
        for (Account a : this.accounts) if (a.getAccountNumber().equals(accountNumber)) return a;
        return null;
    }

}
