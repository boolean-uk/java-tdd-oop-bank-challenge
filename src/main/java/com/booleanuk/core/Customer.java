package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    private final ArrayList<Account> accounts;


    public Customer() {
        this.accounts = new ArrayList<>();
    }


    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public boolean createAccount(Account account) {
        this.accounts.add(account);
        return true;
    }




}
