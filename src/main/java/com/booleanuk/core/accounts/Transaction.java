package com.booleanuk.core.accounts;

import java.time.LocalDateTime;

public class Transaction {
    private double amount;
    private LocalDateTime date;

    private Account account;

    private boolean accepted;

    public Transaction(double amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.accepted =false;
    }

    public Transaction(double amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
        this.accepted =false;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
