package com.booleanuk.core;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Account {
    private int accountNr;
    private double interest;
    private ArrayList<Transaction> transactions;

    public Account(double interest){
        accountNr = 1;
        this.interest = interest;
        transactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    public Transaction deposit(int money){
        Transaction newTransaction = new Transaction(money, 0);
        transactions.add(newTransaction);
        return newTransaction;
    }

    public Transaction withdraw(int money){
        Transaction newTransaction = new Transaction(0, money);
        transactions.add(newTransaction);
        return newTransaction;
    }

    public void statement(){

    }

    public int getBalance(){
        return 0;
    }
}
