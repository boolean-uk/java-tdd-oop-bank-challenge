package com.booleanuk.core.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    AccountType type;
    List<Transaction> transactions = new ArrayList<>();

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be a positive number");
        }

        transactions.add(new Transaction(amount));
    }

    public double getBalance() {
        BigDecimal sum = transactions.stream()
                .map(transaction -> BigDecimal.valueOf(transaction.amount))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sum.doubleValue();
    }
}
