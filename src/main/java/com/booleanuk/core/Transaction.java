package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {

    LocalDateTime data;
    double amount;
    double currentBalance;

    public Transaction(LocalDateTime data, double amount, double currentBalance, String debitOrCredit) {
        this.data = data;
        this.amount = amount;
        this.debitOrCredit = debitOrCredit;
        this.currentBalance = currentBalance;
    }
    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getDebitOrCredit() {
        return debitOrCredit;
    }

    public void setDebitOrCredit(String debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }

    String debitOrCredit;


}
