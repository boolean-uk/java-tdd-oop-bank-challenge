package com.booleanuk.core;

import java.time.LocalDateTime;

public class Transaction {
    private int ID;
    private float amount;
    private LocalDateTime date;
    private int transactionType;

    Transaction(int id, float amount, int transactionType) {
        this.ID = id;
        this.amount = amount;
        this.transactionType = transactionType;
    }
}
