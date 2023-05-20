package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {

    private LocalDateTime date;
    private BigDecimal amount;

    public Transaction(double amount){
        this.date = LocalDateTime.now();
        this.amount = BigDecimal.valueOf(amount);
    }
    public Transaction(LocalDateTime date, double amount) {
        this.date = date;
        this.amount = BigDecimal.valueOf(amount);
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
