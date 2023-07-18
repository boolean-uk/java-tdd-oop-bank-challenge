package com.booleanuk.core;

import java.util.HashMap;

public class Bank {
    private HashMap<Integer, SavingsAccount> savingsAccounts;
    private HashMap<Integer, CurrentAccount> currentAccounts;
    private int accountsCounter;

    public Bank() {
        this.savingsAccounts = new HashMap<>();
        this.currentAccounts = new HashMap<>();
        this.accountsCounter = 0;
    }

    public int openCurrentAccount(String ownerName){
        return 0;
    }

    public int openSavingsAccount(String ownerName){
        return 0;
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
