package com.booleanuk.extension;

import java.util.HashMap;

public class Branch {
    private int nextAccountId = 10000000;
    private HashMap<Long, Account> accounts = new HashMap<>();
    private int branchId;

    public Branch(int branchId) {
        this.branchId = branchId;
    }

    int getId() {
        return branchId;
    }

    HashMap<Long, Account> getAccounts() {
        return accounts;
    }

    CurrentAccount newCurrentAccount() {
        long accountNr = Long.parseLong(String.valueOf(branchId) + String.valueOf(nextAccountId));
        nextAccountId++;
        CurrentAccount acc = new CurrentAccount(accountNr);
        accounts.put(accountNr, acc);
        return acc;
    }

    SavingsAccount newSavingsAccount() {
        long accountNr = Long.parseLong(String.valueOf(branchId) + String.valueOf(nextAccountId));
        nextAccountId++;
        SavingsAccount acc = new SavingsAccount(accountNr);
        accounts.put(accountNr, acc);
        return acc;
    }
}
