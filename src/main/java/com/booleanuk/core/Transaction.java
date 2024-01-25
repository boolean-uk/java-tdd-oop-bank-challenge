package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    LocalDateTime  data;
    double amount;
    double currentBalance;

    String debitOrCredit;

    public Transaction(LocalDateTime data, double amount, double currentBalance, String debitOrCredit) {
        this.data = data;
        this.amount = amount;
        this.debitOrCredit = debitOrCredit;
        this.currentBalance = currentBalance;
    }
}
