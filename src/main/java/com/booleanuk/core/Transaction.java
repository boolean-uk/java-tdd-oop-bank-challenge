package com.booleanuk.core;

import java.math.BigDecimal;

public class Transaction {
    private String date;
    private BigDecimal amount;
    private String operationType;
    public Transaction(String date, BigDecimal amount, String operationType) {
        this.date = date;
        this.amount = amount;
        this.operationType = operationType;
    }

    public String getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getOperationType() {
        return operationType;
    }
}
