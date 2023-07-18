package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class BankAccount {
    protected final LinkedList<Transaction> transactionHistory;
    protected final LocalDateTime openDate;
    protected String number;
    private final Branch branch;
    public BankAccount() {
        this.transactionHistory = new LinkedList<Transaction>();
        this.openDate = LocalDateTime.now();
        this.number = "";
        this.branch = null;
    }
    public BankAccount(double initialBalance) {
        this.transactionHistory = new LinkedList<Transaction>();
        this.transactionHistory.add(new Transaction(initialBalance));
        this.openDate = LocalDateTime.now();
        this.number = "";
        this.branch = null;
    }
    public BankAccount(double initialBalance, Branch branch) {
        this.transactionHistory = new LinkedList<Transaction>();
        this.transactionHistory.add(new Transaction(initialBalance));
        this.openDate = LocalDateTime.now();
        this.number = "";
        this.branch = branch;
    }
    public double getBalance() {
        double balance = 0.0;
        for(Transaction transaction : transactionHistory)
            balance += transaction.getAmount() - transaction.getFee();
        return balance;
    }
    public LocalDateTime getOpenDate() {
        return openDate;
    }
    public Branch getBranch() {
        return branch;
    }
    public boolean withdraw(double amount) {
        if(getBalance() < amount)
            return false;
        transactionHistory.add(new Transaction(-amount));
        return true;
    }
    public void deposit(double amount) {
        transactionHistory.add(new Transaction(amount, 0.0));
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
                double debit = Math.round((transaction.getAmount() - transaction.getFee()) * 100.0) / 100.0;
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
            double fee = transaction.getFee();
            balance += amount - fee;
            double roundedBalance = Math.round(balance * 100.0) / 100.0;
            sb.append(transaction.getDate().format(formatter));
            sb.append(" || ");
            sb.append(Functions.padLeftSpaces(amount >= 0.0 ? String.format("%.2f", amount) :
                    "", maxCreditLength));
            sb.append(" || ");
            sb.append(Functions.padLeftSpaces(amount < 0.0 ? String.format("%.2f", amount - fee) :
                    "", maxDebitLength));
            sb.append(" || ");
            sb.append(Functions.padLeftSpaces(String.format("%.2f", roundedBalance), maxBalanceLength));
            sb.append("\n");
        }
        return sb.toString();
    }
}
