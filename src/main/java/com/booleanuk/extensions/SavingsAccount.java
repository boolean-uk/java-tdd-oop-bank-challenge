package com.booleanuk.extensions;

import java.util.Date;

public class SavingsAccount extends Account {

    public SavingsAccount(Branch branch) {
        super(branch);
    }

    @Override
    public void addTransaction(Date date, double amount, double balance) {
        Transaction transaction = new Transaction(date, amount, balance);
        transactions.add(transaction);
    }

    @Override
    public double getBalance() {
        double balance = 0.0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }
}