package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {
    double balance;
    List<Transaction> transactionsHistory;

    public Account() {
        transactionsHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionsHistory() {
        return transactionsHistory;
    }
}
