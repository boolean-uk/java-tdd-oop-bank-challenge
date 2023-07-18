package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private final long number;
    private BigDecimal balance;
    private List<Transaction> transactionList;

    public BankAccount(long number) {
        this.number = number;
        this.balance = BigDecimal.valueOf(0);
        transactionList = new ArrayList<>();
    }

    public long getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

}
