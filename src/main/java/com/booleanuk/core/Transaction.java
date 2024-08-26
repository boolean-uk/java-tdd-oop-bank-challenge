package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime date;
    private String balance;
    private String amount;

    public Transaction(String amount, int balance) {
        this.date = LocalDateTime.now();
        this.amount = amount;
        this.balance =  "£" + String.format("%.2f", balance/100f);
    }
    public String getBalance() {
        return balance;
    }

    public String getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
