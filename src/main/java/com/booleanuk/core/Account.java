package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private final List<Transaction> transactions = new ArrayList<>();

    public void deposit(BigDecimal amount, LocalDate date) {
        addTransaction(amount, date);
    }

    public void withdraw(BigDecimal amount, LocalDate date) {
        if(getBalance().compareTo(amount) < 0)
            throw new IllegalArgumentException("You don't have that much money.");
        addTransaction(amount.negate(), date);
    }

    public BigDecimal getBalance() {
        return transactions.stream()
                .map(Transaction::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    private void addTransaction(BigDecimal amount, LocalDate date) {
        Transaction transaction = new Transaction(amount, date);
        transactions.add(transaction);
    }
}
