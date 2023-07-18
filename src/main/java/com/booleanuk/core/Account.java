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

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = BigDecimal.ZERO;
        this.transactions = new ArrayList<>();
        this.random = new Random();
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public List<Transaction> getTransactions(){
        return transactions;
    }
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
}
