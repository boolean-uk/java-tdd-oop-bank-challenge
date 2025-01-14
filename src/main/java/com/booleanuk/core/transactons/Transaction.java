package com.booleanuk.core.transactons;

import com.booleanuk.core.idgenerator.IdGenerator;
import com.booleanuk.core.idgenerator.IdPrefix;

import java.time.LocalDateTime;

public class Transaction {

    private String id;
    private LocalDateTime transactionDate;
    private Double amount;
    private TransactionType type;
    private Double currentBalance;

    public Transaction(String id, Double amount, TransactionType type, Double currentBalance) {
        this.id = id;
        this.transactionDate = LocalDateTime.now(); // TODO: Format later
        this.amount = amount;
        this.type = type;
        this.currentBalance = currentBalance;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }
}
