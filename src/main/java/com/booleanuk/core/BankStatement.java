package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BankStatement {
    private double balance;
    private double amount;
    private LocalDate date;

    public BankStatement(){
        this.amount = amount;
        this.balance = 0.0;
        this.date = date;
    }

    public LocalDate getDate(){
        return this.date = LocalDate.now();
    }

    public double getBalance(){
        return this.balance;
    }

    public double getAmount() {
        return this.amount;
    }

    public double deposit(double amount1){
        this.balance += amount1;
        return this.balance;
    }

    public double withdraw(double amount1){
        this.balance -= amount1;
        return this.balance;

    }
}
