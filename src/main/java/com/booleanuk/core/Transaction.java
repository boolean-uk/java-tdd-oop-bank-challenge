package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private String date;
    private int amount;
    private int currentBalance;

    public Transaction(int amount, int previousAmount){
        this.date = LocalDate.now().toString();
        this.amount = amount;
        this.currentBalance = previousAmount + amount;
    }

    public String getDate(){
        return this.date;
    }

    public int getAmount(){
        return this.amount;
    }

    public int getCurrentBalance(){
        return this.currentBalance;
    }
}
