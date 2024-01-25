package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private double balance;
    private String type;
    private List<Transaction> transactions;

    public Account (String accountNumber, double balance, String type) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.transactions = new ArrayList<>();
    }

    public double addFunds(double amount) {
        balance += amount;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        transactions.add(new Transaction(dateTime, amount, 0d, balance));

        return balance;
    }

    

    public static void main(String[] args) {
        CurrentAccount currentAccount = new CurrentAccount("1234C",50d);

        System.out.println(currentAccount.addFunds(100));

    }








    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
