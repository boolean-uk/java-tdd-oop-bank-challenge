package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
    private final ArrayList<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
