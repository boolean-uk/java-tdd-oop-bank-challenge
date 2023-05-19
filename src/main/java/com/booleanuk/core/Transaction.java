package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {

    private Date date;
    private BigDecimal amount;

    public Transaction(Date date, double amount) {
        this.date = date;
        this.amount = BigDecimal.valueOf(amount);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
