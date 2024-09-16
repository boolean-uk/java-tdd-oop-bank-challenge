package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Account {
    private String accountNumber;
    protected BigDecimal balance;
    List<Transaction> transactions;
    private final Random random;
    protected Client client;
    protected BigDecimal overdraftLimit;

    public Account(String accountNumber, Client client) {
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.ZERO;
        this.transactions = new ArrayList<>();
        this.random = new Random();
        this.client = client;
        this.overdraftLimit = BigDecimal.ZERO;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public abstract BigDecimal getBalance();

    public abstract void deposit(BigDecimal amount);

    public abstract void withdraw(BigDecimal amount);

    protected LocalDateTime generateRandomDateTime() {
        int year = LocalDateTime.now().getYear();
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1;
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);

        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setOverdraftLimit(BigDecimal overdraftLimit) {
        if (overdraftLimit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative.");
        }
        this.overdraftLimit = overdraftLimit;
    }

    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }

    public void requestOverdraft(BigDecimal amount) {
        BigDecimal totalBalance = balance.add(overdraftLimit);

        if (amount.compareTo(totalBalance) <= 0) {
            balance = balance.subtract(amount);
        } else {
            System.out.println("You can't complete your debit request. Insufficient resources.");
        }
    }
}
