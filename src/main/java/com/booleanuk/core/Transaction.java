package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String date;
    private int amount;
    private int currentBalance;

    public Transaction(int amount, int previousAmount){
        this.date = formatDate();
        this.amount = amount;
        this.currentBalance = previousAmount + amount;
    }

    public String formatDate(){
        LocalDateTime date = LocalDateTime.now();
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
