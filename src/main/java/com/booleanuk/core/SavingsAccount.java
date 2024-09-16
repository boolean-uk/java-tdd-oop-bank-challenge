package com.booleanuk.core;

import java.math.BigDecimal;

public class SavingsAccount extends Account {


    public SavingsAccount(String accountNumber,Client client) {
        super(accountNumber,client);
        this.overdraftLimit = BigDecimal.ZERO;
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
    @Override
    public BigDecimal getBalance() {
        return balance;
    }
    @Override
    public void requestOverdraft(BigDecimal amount) {
        System.out.println("Savings accounts do not have debit functionality available.");
    }
}
