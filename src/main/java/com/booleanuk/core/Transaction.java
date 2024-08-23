package com.booleanuk.core;


import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime date;
    private int amount;
    private String type;
    private boolean isCredit;

    Transaction(LocalDateTime localDateTime, int amount, boolean isCredit) {
        this.date = localDateTime;
        this.amount = amount;
        this.type = type;
        this.isCredit = isCredit;
    }

    public boolean getIsCredit() {
        return isCredit;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
