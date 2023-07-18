package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class BankAccount {
    protected final LinkedList<Transaction> transactionHistory;
    protected double balance;
    protected final LocalDateTime openDate;

    public BankAccount() {
        transactionHistory = new LinkedList<Transaction>();
        balance = 0.0;
        openDate = LocalDateTime.now();
    }
    public BankAccount(double initialBalance) {
        transactionHistory = new LinkedList<Transaction>();
        transactionHistory.add(new Transaction(initialBalance));
        balance = initialBalance;
        openDate = LocalDateTime.now();
    }
    public double getBalance() {
        return balance;
    }
    public LocalDateTime getOpenDate() {
        return openDate;
    }
    public boolean withdraw(double amount) {
        if(balance < amount || amount < 0.0)
            return false;
        transactionHistory.add(new Transaction(-amount));
        balance -= amount;
        return true;
    }
    public void deposit(double amount) {
        transactionHistory.add(new Transaction(amount, 0.0));
        balance += amount;
    }
    public String generateStatement() {
        int maxCreditLength = 0;
        int maxDebitLength = 0;
        int maxBalanceLength = 0;
        double balance = 0.0;
        for(Transaction transaction : transactionHistory) {
            if (transaction.getAmount() >= 0.0) {
                double credit = Math.round(transaction.getAmount() * 100.0) / 100.0;
                maxCreditLength = Math.max(maxCreditLength, String.format("%.2f", credit).length());
            }
            else if (transaction.getAmount() < 0.0) {
                double debit = Math.round(transaction.getAmount() * 100.0) / 100.0;
                maxDebitLength = Math.max(maxDebitLength, String.format("%.2f", debit).length());
            }
            balance += transaction.getAmount();
            double roundedBalance = Math.round(balance * 100.0) / 100.0;
            maxBalanceLength = Math.max(maxBalanceLength, String.format("%.2f", roundedBalance).length());
        }
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sb.append("date       || ");
        sb.append(Functions.padRightSpaces("credit", maxCreditLength));
        sb.append(" || ");
        sb.append(Functions.padRightSpaces("debit", maxDebitLength));
        sb.append(" || balance\n");
        balance = 0.0;
        for(Transaction transaction : transactionHistory) {
            double amount = transaction.getAmount();
            balance += amount;
            double roundedBalance = Math.round(balance * 100.0) / 100.0;
            sb.append(transaction.getDate().format(formatter));
            sb.append(" || ");
            sb.append(Functions.padLeftSpaces(amount >= 0.0 ? String.format("%.2f", amount) :
                    "", maxCreditLength));
            sb.append(" || ");
            sb.append(Functions.padLeftSpaces(amount < 0.0 ? String.format("%.2f", amount) :
                    "", maxDebitLength));
            sb.append(" || ");
            sb.append(Functions.padLeftSpaces(String.format("%.2f", roundedBalance), maxBalanceLength));
            sb.append("\n");
        }
        return sb.toString();
    }
}
