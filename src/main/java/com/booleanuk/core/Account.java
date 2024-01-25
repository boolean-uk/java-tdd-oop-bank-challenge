package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountId;
    private Customer customer;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountId, Customer customer) {
        this.accountId = accountId;
        this.customer = customer;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return this.accountId;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    public double getBalance() {
        return this.balance;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
