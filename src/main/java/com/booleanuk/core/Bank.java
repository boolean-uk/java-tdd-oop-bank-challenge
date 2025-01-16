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
            CurrentAccount currentAccount = new CurrentAccount(transactions, ID, initialBalance);
        } else if (Objects.equals(type, "savingsAccount")) {
            HashMap<Integer, Transaction> transactions = new HashMap<>();
            double initialBalance = 0.0;
            SavingsAccount savingsAccount = new SavingsAccount(transactions, ID, initialBalance);
        }
        return "Account created successfully!";
    }
}
