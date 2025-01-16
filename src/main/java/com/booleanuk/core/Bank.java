package com.booleanuk.core;

import java.util.HashMap;
import java.util.Objects;

public class Bank {
    private HashMap<String, BankAccount> accounts;

    public Bank(HashMap<String, BankAccount> accounts) {
        this.accounts = accounts;
    }

    public String createAccount(String branch, String type, int ID) {
        if (Objects.equals(type, "currentAccount")) {
            HashMap<Integer, Transaction> transactions = new HashMap<>();
            double initialBalance = 0.0;
            CurrentAccount currentAccount = new CurrentAccount(branch, transactions, ID, initialBalance);
            accounts.put(branch, currentAccount);
        } else if (Objects.equals(type, "savingsAccount")) {
            HashMap<Integer, Transaction> transactions = new HashMap<>();
            double initialBalance = 0.0;
            SavingsAccount savingsAccount = new SavingsAccount(branch, transactions, ID, initialBalance);
            accounts.put(branch, savingsAccount);
        }
        return "Account created successfully!";
    }
}
