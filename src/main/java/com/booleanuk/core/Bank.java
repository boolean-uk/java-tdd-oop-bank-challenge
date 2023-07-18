package com.booleanuk.core;

import java.util.HashMap;

public class Bank {
    private final HashMap<Integer, SavingsAccount> savingsAccounts;
    private final HashMap<Integer, CurrentAccount> currentAccounts;
    private int accountsCounter;

    public Bank() {
        this.savingsAccounts = new HashMap<>();
        this.currentAccounts = new HashMap<>();
        this.accountsCounter = 0;
    }

    public int openCurrentAccount(String ownerName){
        currentAccounts.put(accountsCounter++,new CurrentAccount(ownerName));
        return accountsCounter;
    }

    public int openSavingsAccount(String ownerName){
        savingsAccounts.put(accountsCounter++,new SavingsAccount(ownerName));
        return accountsCounter;
    }

    public HashMap<Integer, SavingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }

    public HashMap<Integer, CurrentAccount> getCurrentAccounts() {
        return currentAccounts;
    }

    public int getAccountsCounter() {
        return accountsCounter;
    }
}
