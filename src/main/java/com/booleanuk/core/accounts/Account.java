package com.booleanuk.core.accounts;

import com.booleanuk.core.Transaction;

import java.util.ArrayList;

abstract class Account {
    private String firstName;
    private String lastName;
    private String accountNumber;
    private ArrayList<Transaction> transactions;

    public Account(String firstName, String lastName, String accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.transactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
