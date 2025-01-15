package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Random;

public class Account {
    //Extension: need a branch ID)
    private double balance;
    private final ArrayList<Transaction> transactions;
    private final int accountNumber;
    private StringBuilder stringbuilder = new StringBuilder();

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        this.stringbuilder.insert(0, String.format("%21s || %10s || %8s || %8s\n", "Date", "Withdrawal", "Deposit", "Balance"));
    }

    //Allows the creation of accounts without providing a number as well
    public Account() {
        Random rand = new Random();
        //account numbers can't start with 0, but I also think that's the case IRL
        this.accountNumber = rand.nextInt(10000000, 99999999);
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        this.stringbuilder.insert(0, String.format("%21s || %10s || %8s || %8s\n", "Date", "Withdrawal", "Deposit", "Balance"));
    }

    public void makeTransaction(double amount) {
        if (this.balance + amount > 0) {
            this.balance += amount;
            Transaction transaction = new Transaction(amount);
            this.transactions.add(transaction);
            //It might seem a bit odd to already start generating the statement here, but the only alternative I can think of
            //is that Transaction gets to know about the balance of the account despite it just being a record class.
            //Looping over the transaction list after every transaction has been completed only gives the final balance, not the balance after each transaction
            this.stringbuilder.append(String.format(transaction + "%8s\n", this.balance));
        }

    }

    public StringBuilder generateStatement() {
        return this.stringbuilder;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public double getBalance() {
        double total = 0.0;
        for (Transaction transaction: this.transactions) {
            if (transaction.getType().equals("deposit")) {
                total += transaction.getAmount();
            } else {
                total -= transaction.getAmount();
            }
        }
        return total;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }



}
