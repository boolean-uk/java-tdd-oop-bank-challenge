package com.booleanuk.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final Account account;
    private LocalDate localDate;
    private double deposit;
    private double withdraw;
    private double balance;

    public Transaction(Account account) {
        this.account = account;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            localDate = LocalDate.now();
            deposit = amount;
            balance = account.getBalance();
        } else {
            System.out.println("Wrong amount of money!");
        }
    }

    public String getLocalDateFormatted() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(dateTimeFormatter);
    }

    public void withdraw(double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            localDate = LocalDate.now();
            withdraw = amount;
            balance = account.getBalance();
            System.out.println("You withdraw: " + amount);
        } else {
            System.out.println("You can't withdraw: " + amount + ". Your balance is: " + account.getBalance());
        }

    }

    public double getDeposit() {
        return deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public double getBalance() {
        return balance;
    }
}
