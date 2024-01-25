package com.booleanuk.core;

import java.util.Date;

public class SavingsAccount extends Account {

    @Override
    public void addTransaction(Date date, double amount, double balance) {
        Transaction transaction = new Transaction(date, amount, balance);
        transactions.add(transaction);
    }
}