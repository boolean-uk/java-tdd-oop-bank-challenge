package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private String accountID;
    private double balance;
    private List<String> transactions;
    private boolean headerPrinted = false;



    public Account(double balance) {
        this.accountID = generateRandomAccountId();
        this.balance = balance;
        this.transactions = new ArrayList<>();


    }


    public void addTransaction(double amount, String type) {

        if (!headerPrinted) {
            printHeader();
            headerPrinted = true;
        }

        String date = LocalDate.now().toString().replace("-", "/");
        String credit = type.equals("credit") ? String.format("%.2f", amount) : "";
        String debit = type.equals("debit") ? String.format("%.2f", amount) : "";
        String balanceStr = String.format("%.2f", this.balance);

        StringBuilder transaction = new StringBuilder();
        transaction.append(String.format("%-10s || ", date))
                .append(String.format("%-7s || ", credit))
                .append(String.format("%-7s || ", debit))
                .append(String.format("%-7s", balanceStr));

        transactions.add(transaction.toString());
        System.out.println(transaction);

    }


    private String generateRandomAccountId() {
        long randomNumber = (long) (Math.random() * 1_000_000_000_000L);
        return String.format("%012d", randomNumber);
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            addTransaction(amount, "credit");
            return "Deposit Successful";
        }

        return "The amount should be positive!";
    }

    public String withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            addTransaction(amount, "debit");
            return "Withdrawal successful";
        }
        return "Insufficient funds!";
    }


    public void printHeader() {
        String header = String.format("%-10s || %-7s || %-7s || %-7s", "date", "credit", "debit", "balance");
        System.out.println(header);
    }

    public boolean isHeaderPrinted() {
        return headerPrinted;
    }

    public void setHeaderPrinted(boolean headerPrinted) {
        this.headerPrinted = headerPrinted;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
}
