package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private BigDecimal amount;

    public Transaction(BigDecimal amount) {
        this.date = LocalDate.now();
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
