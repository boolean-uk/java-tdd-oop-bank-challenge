package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    private String accountName;
    private String accountID;
    private ArrayList<Transaction> transactions;
    private int balance;

    public Account(String accountName)
    {
        this.accountName = accountName;
        this.accountID = ""; // Will get to that
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }
}
