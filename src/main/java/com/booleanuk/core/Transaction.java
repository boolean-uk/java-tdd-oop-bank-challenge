package com.booleanuk.core;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String date;
    private double amount;
    private double balance;
    private TransactionType type;
    LocalDateTime dater = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY/MM/dd");


    Transaction(TransactionType type, double amount, double balance){
        this.date = dater.format(formatter);
        this.type = type;
        this.amount = amount;
        this.balance = balance;
    }

    public TransactionType getType(){
        return this.type;
    }

    public String getDate(){
        return this.date;
    }

    public double getAmount(){
        return this.amount;
    }

    public double getBalance(){
        return this.balance;
    }


}
