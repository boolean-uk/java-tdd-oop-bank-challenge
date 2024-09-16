package com.booleanuk.core;

public class Customer {
    public int id;
    public Account [] accounts;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Customer (int id) {
        this.id = id;

    }
}
