package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class BankAccount {
    private HashMap<Integer, Transaction> transactions;
    private int accountNumber;
    private double balance;

    public BankAccount(HashMap<Integer, Transaction> transactions, int accountNumber, double balance) {
        this.transactions = transactions;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        Collection<Transaction> collection = transactions.values();
        double balance = 0;
        for (Transaction transaction : collection) {
            if (Objects.equals(transaction.getType(), "credit")) {
                balance += transaction.getAmount();
            } else {
                balance -= transaction.getAmount();
            }
            System.out.println(balance);
        }
        return balance;
    }

    public String deposit(double amount) {
        int ID = (int) (Math.random()* 90000) + 10000;
        String type = "credit";
        String date = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        double balanceAfter = balance += amount;
        transactions.put(ID, new Transaction(ID, type, amount, date, balanceAfter));
        return "Deposit successfull!";
    }
}
