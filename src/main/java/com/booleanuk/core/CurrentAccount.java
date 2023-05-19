package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;

public class CurrentAccount implements Account {
    private int balance;
    private ArrayList <Transaction> transactions;

    public CurrentAccount(double balance) {

        this.balance = Util.fromDoubleToInt(balance);
        this.transactions=new ArrayList<Transaction>();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {

        return Util.fromIntToDouble(balance);
    }

    public void setBalance(double balance) {
        this.balance = Util.fromDoubleToInt(balance);
    }

    @Override
    public void deposit(double amount, LocalDate date) {
        this.setBalance(getBalance() + amount);
        this.transactions.add(new Transaction(date,TransactionType.CREDIT,amount, this.getBalance()));
    }

    @Override
    public void withdraw(double amount, LocalDate date) {

    }

    @Override
    public void generateStatement() {

    }

}
