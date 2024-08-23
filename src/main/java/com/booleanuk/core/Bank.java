package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    private int idCounter;
    private HashMap<Integer, Account> accounts;
    private ArrayList<String> branches;

    public Bank() {
        this.idCounter = 0;
        this.accounts = new HashMap<>();
        this.branches = new ArrayList<>();
    }

    public int createAccount(String type, String branch) {
        Account newAccount = new SavingsAccount(idCounter, branch);
        this.idCounter++;
        return newAccount.getId();
    }

    public int calculateOverdraft() {
        return 0;
    }

    public int getIdCounter() {
        return idCounter;
    }


    public Account getAccount(int id) {
        for (int accountId : this.accounts.keySet()) {
            if (accountId == id) {
                return this.accounts.get(id);
            }
        }
        System.out.println("No such account exists.");
        return null;
    }
}
