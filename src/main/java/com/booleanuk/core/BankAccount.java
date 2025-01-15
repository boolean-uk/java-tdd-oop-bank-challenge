package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BankAccount {
    private final int accountNumber;
    private final List<Transaction> transactions;

    public BankAccount() {
        Random random = new Random();
        // account nrs can technically have leading 0s, but i'm not allowing that here
        this.accountNumber = random.nextInt(10000000, 99999999);
        this.transactions = new ArrayList<>();
    }

    public boolean withdraw(double amount) {
        double balance = this.getBalance();
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction(-amount, balance, LocalDateTime.now()));
        }
        return amount <= balance;
    }

    // maybe can be void... or maybe consider overflow?
    public boolean deposit(double amount) {
        double balance = this.getBalance();
        balance += amount;
        transactions.add(new Transaction(amount, balance, LocalDateTime.now()));
        return true;
    }

    // TODO Fix formatting
    public String generateBankStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append("date\t||credit\t||debit\t||balance\n");

        for (Transaction t : transactions.reversed()) {
            sb.append(t.getDateTime().getDayOfMonth()).append("/")
                    .append(t.getDateTime().getMonthValue()).append("/")
                    .append(t.getDateTime().getYear()).append("||");
            if (t.getAmount() > 0) {
                sb.append(String.format("%.2f", Math.abs(t.getAmount()))).append("||\t");
            } else {
                sb.append("\t||").append(String.format("%.2f", Math.abs(t.getAmount())));
            }
            sb.append("||").append(String.format("%.2f", t.getCurrentBalance())).append("\n");
        }

        return sb.toString();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        double balance = 0;
        for (Transaction t : transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
