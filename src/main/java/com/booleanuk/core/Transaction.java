package com.booleanuk.core;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private String transactionType;
    private double amount;
    private Date date;

    public Transaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = new Date();
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public String getCredit() {
        return transactionType.equals("Deposit") ? String.format("%.2f", amount) : "";
    }

    public String getDebit() {
        return transactionType.equals("Withdrawal") ? String.format("%.2f", amount) : "";
    }

    public double getBalance() {
        return amount;
    }
}