package com.booleanuk.core;

import java.util.ArrayList;

public class SavingsAccount implements Account {

    private ArrayList<Transaction> transactions;
    private double balance;
    private final Customer customer;

    public SavingsAccount(Customer customer) {
        this.customer = customer;
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    @Override
    public double deposit(double amount) {
        if(amount > 0) {
            this.transactions.add(new Transaction(amount, this));
            return setBalance(this.balance+amount);
        } else {
            return this.balance;
        }
    }

    @Override
    public double withdraw(double amount) {
        if(amount > 0) {
            this.transactions.add(new Transaction(-amount, this));
            return setBalance(this.balance-amount);
        } else {
            return this.balance;
        }
    }

    @Override
    public String transactionListToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(
                "%-20s %-10s %-10s %-10s %s",
                "\t\t\tdate",
                "credit",
                "debit",
                "balance",
                "\n"
        ));
        for(Transaction t : transactions) {
            stringBuilder.append(t.toString());
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    @Override
    public double getBalance() {
        return balance;
    }

    private double setBalance(double balance) {
        this.balance = balance;
        return this.balance;
    }
}
