package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private final long number;
    private List<Transaction> transactionList;

    public BankAccount(long number) {
        this.number = number;
        transactionList = new ArrayList<>();
    }

    public long getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        BigDecimal b = BigDecimal.ZERO;
        for(Transaction t : transactionList){
            b=b.add(t.getAmount());
        }
        return b;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

}
