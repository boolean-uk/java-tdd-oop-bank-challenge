package com.booleanuk.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class BankAccount {
    private HashMap<Integer, Transaction> transactions;
    private int accountNumber;
    private double balance;

    public BankAccount(HashMap<Integer, Transaction> transactions, int accountNumber, double balance) {
        this.transactions = transactions;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        Collection<Transaction> collection = transactions.values();
        double balance = 0;
        for (Transaction transaction : collection) {
            if (Objects.equals(transaction.getType(), "credit")) {
                balance += transaction.getAmount();
            } else {
                balance -= transaction.getAmount();
            }
            System.out.println(balance);
        }
        return balance;
    }
}
