package com.booleanuk.core.accounts;

import com.booleanuk.core.users.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected static long accountCount = 0;
    protected long id;
    protected List<Transaction> transactionHistory;
    protected Customer user;
    protected double maxOverdraft = 0.0;

    public Account(Customer user) {
        this.user = user;
        this.transactionHistory = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction){}

    public double calculateBalance(LocalDateTime dateTime){return 0.0;}

    public static long getAccountCount() {
        return accountCount;
    }

    public long getId() {
        return id;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public Customer getUser() {
        return user;
    }

    public double getMaxOverdraft() {
        return maxOverdraft;
    }
}
