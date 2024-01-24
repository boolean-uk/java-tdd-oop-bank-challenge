package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Account> accounts;


    public Customer() {
        this.accounts = new ArrayList<>();
    }


    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
