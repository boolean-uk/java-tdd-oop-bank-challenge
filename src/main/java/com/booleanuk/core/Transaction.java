package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private final int amount;


    private final int newBalance;
    private final TransactionType type;
    private final Account account;
    private final LocalDate date;
    private final LocalTime time;

    public int getAmount() {
        return amount;
    }

    public int getNewBalance() {
        return newBalance;
    }


    public TransactionType getType() {
        return type;
    }



    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }



    public Transaction(TransactionType type, Account account, int amount) throws InvalidTransactionTypeException {
        if(!(type.equals(TransactionType.WITHDRAWAL) || type.equals(TransactionType.DEPOSIT))) {
            throw new InvalidTransactionTypeException("The type: " + type + " needs a receiving account");
        }
        if(type == TransactionType.DEPOSIT) {
            this.newBalance = account.getBalance() + amount;
        } else if (type == TransactionType.WITHDRAWAL) {
            this.newBalance = account.getBalance() - amount;
        } else {
            this.newBalance = 0;
        }
        this.account = account;
        this.type = type;
        this.amount = amount;
        this.date = LocalDate.now();
        this.time = LocalTime.now();

    }

    @Override
    public String toString() {
        return "";
    }
}
