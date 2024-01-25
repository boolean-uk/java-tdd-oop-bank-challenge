package com.booleanuk.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Transaction {
    private final Date date;
    private final double amount;
    private final double balance;

    public Transaction(Date date, double amount, double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Date getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public static String generateTransactions(List<Transaction> transactions) {
        StringBuilder result = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        result.append("date       || credit  || debit  || balance\n");

        for (Transaction transaction : transactions) {
            result.append(String.format("%s || %6s || %6s || %8s\n",
                    dateFormat.format(transaction.getDate()),
                    (transaction.getAmount() > 0) ? String.format("%.2f", transaction.getAmount()) : "",
                    (transaction.getAmount() < 0) ? String.format("%.2f", -transaction.getAmount()) : "",
                    String.format("%.2f", transaction.getBalance())));
        }

        return result.toString();
    }
}