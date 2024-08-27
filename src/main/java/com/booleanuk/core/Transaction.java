package com.booleanuk.core;

import java.time.LocalDate;
import java.util.UUID;

public class Transaction {

    private String id;
    private LocalDate date;
    private int credit;
    private int debit;

    public Transaction(int credit, int debit){
        this.id = UUID.randomUUID().toString();
        this.date = LocalDate.now();
        this.credit = credit;
        this.debit = debit;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCredit() {
        return credit;
    }

    public int getDebit() {
        return debit;
    }
}
