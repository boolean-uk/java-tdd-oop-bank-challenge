package com.booleanuk.core;

import java.math.BigDecimal;

public class CurrentAccount extends Account {

    public CurrentAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        transactions.add(new Transaction(generateRandomDateTime(), amount, TransactionType.DEPOSIT));
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            transactions.add(new Transaction(generateRandomDateTime(), amount, TransactionType.WITHDRAWAL));
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}
