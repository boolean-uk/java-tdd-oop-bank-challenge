package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountType;
    private ArrayList<Transaction> transactions;
    private int balance;

    public Account(String accountType) {
        this.accountType = accountType;
        balance = 0;
        transactions = new ArrayList<>();
    }
    public void addTransaction(String date, int amount)
    {
        transactions.add(new Transaction(date,amount));
    }
    public int getCurrentBalance()
    {
        int currentBalance = 0;
        for (Transaction transaction : transactions)
        {
            currentBalance+=transaction.getAmount();
        }
        return  currentBalance;
    }
}
