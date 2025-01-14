package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Account {
    private double balance = 0;
    private HashMap<String, Double> depositHistory = new HashMap<>();
    private HashMap<String, Double> withdrawHistory = new HashMap<>();
    private String depositDate;

    public Account(double balance) {
        this.balance = balance;
        this.depositHistory = depositHistory;
        this.withdrawHistory = withdrawHistory;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public HashMap<String, Double> getDepositHistory() {
        return depositHistory;
    }

    public void setDepositHistory(HashMap<String, Double> depositHistory) {
        this.depositHistory = depositHistory;
    }

    public HashMap<String, Double> getWithdrawHistory() {
        return withdrawHistory;
    }

    public void setWithdrawHistory(HashMap<String, Double> withdrawHistory) {
        this.withdrawHistory = withdrawHistory;
    }

    public double deposit(Account account, double amount) {
        account.addBalance(amount);
        depositDate = java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm\n"));
        return account.getBalance();
    }
}
