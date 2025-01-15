package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private float amount;
    private LocalDateTime transactionDate;
    private UUID ID;
    private UUID accountID;

    public Transaction(UUID accountID, float amount) {
        this.accountID = accountID;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
        this.ID = UUID.randomUUID();
    }

    public float getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public UUID getID() {
        return ID;
    }

    public UUID getAccountID() {
        return accountID;
    }
}
