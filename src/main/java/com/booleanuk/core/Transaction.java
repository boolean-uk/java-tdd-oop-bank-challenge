package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private final LocalDateTime date;
    private final BigDecimal amount;
    private final TransactionType type;

    public Transaction(LocalDateTime date, BigDecimal amount,TransactionType type){
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
    @Override
    public String toString(){
        return date.toLocalDate() + " " + date.toLocalTime()+  " || " + (type==TransactionType.DEPOSIT ? amount : "") + " || " +
                (type == TransactionType.WITHDRAWAL ? amount : "") + " || ";

    }
}
