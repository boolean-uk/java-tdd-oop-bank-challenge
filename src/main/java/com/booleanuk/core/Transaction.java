package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private final int amount;
    private final TransactionType type;
    private final Account receiving;
    private final Account sending;
    private final LocalDate date;
    private final LocalTime time;

    public int getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public Account getReceiving() {
        return receiving;
    }

    public Account getSending() {
        return sending;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }



    public Transaction(TransactionType type, Account sending, int amount) throws InvalidTransactionTypeException {
        if(!(type.equals(TransactionType.WITHDRAWAL) || type.equals(TransactionType.DEPOSIT))) {
            throw new InvalidTransactionTypeException("The type: " + type + " needs a receiving account");
        }
        this.type = type;
        this.sending = sending;
        this.receiving = null;
        this.amount = amount;

        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public Transaction(TransactionType type, Account sending, Account receiving, int amount) {
        this.sending = sending;
        this.receiving = receiving;
        this.amount = amount;
        this.type = type;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    @Override
    public String toString() {
        return "";
    }
}
