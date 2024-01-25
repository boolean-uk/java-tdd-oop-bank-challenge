package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private double balance;
    private final int id;
    List<Transaction> transactions;

    public Account(User user){
        this.balance = 0.00;
        this.id = user.getId();
        this.transactions = new ArrayList<>();
    }

    public double getBalance(){
        return this.balance;
    }

    public void withdraw(double debit){

        if(this.balance - debit < 0){
            System.out.println("Unable to withdraw more than balance!");
            return;
        }
        LocalDateTime dateTime = LocalDateTime.now();
        transactions.add(new Transaction(dateTime,debit, 0, this.balance));
        this.balance -= debit;
    }

    public void deposit(double credit){
        LocalDateTime dateTime = LocalDateTime.now();
        transactions.add(new Transaction(dateTime,0, credit, this.balance));
        this.balance += credit;
    }
}
