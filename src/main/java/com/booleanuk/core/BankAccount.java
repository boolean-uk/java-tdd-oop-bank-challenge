package com.booleanuk.core;

import java.util.ArrayList;

public abstract class BankAccount {
    private final ArrayList<Transaction> transactions;

    public BankAccount(){
        transactions = new ArrayList<>();
    }

    public void deposit(double amount){
        this.transactions.add(new Transaction(amount, true));
    }

    public void withdraw(double amount){
        this.transactions.add(new Transaction(amount, false));
    }

    public String generateStatements() {
        return "";
    }
}
