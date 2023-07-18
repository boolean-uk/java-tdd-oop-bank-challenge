package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private LocalDateTime createdAt;
    private BigDecimal value;


    public Transaction(LocalDateTime createdAt, BigDecimal value) {
        this.createdAt = createdAt;
        this.value = value;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
