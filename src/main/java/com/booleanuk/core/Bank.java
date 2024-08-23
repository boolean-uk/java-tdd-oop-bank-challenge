package com.booleanuk.core;

import java.util.HashMap;

public class Bank {
    private int idCounter;
    private HashMap<Integer, Account> accounts;

    public Bank() {
        this.idCounter = 0;
        this.accounts = new HashMap<>();
    }

    public int calculateOverdraft() {
        return 0;
    }

    public int getIdCounter() {
        return idCounter;
    }


    public HashMap<Integer, Account> getAccounts() {
        return accounts;
    }
}
