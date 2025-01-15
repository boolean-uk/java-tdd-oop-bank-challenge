package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    private static int idCounter;
    private int id;
    private LocalDateTime localDateTime;
    private double amount;
    private double balance;
    private String type;

    public Transaction(LocalDateTime localDateTime, double amount, double balance, String type){
        this.localDateTime = localDateTime;
        this.amount = amount;
        this.balance = balance;
        this.type = type;
        id = idCounter++;
    }

    public String toString(){
        return "Date: " + localDateTime + " || amount: " + type + amount + " || balance: " + balance + "\n";
    }
}
