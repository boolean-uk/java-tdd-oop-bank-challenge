package com.booleanuk.extension;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    List<Transaction> transactions = new ArrayList<>();
    Branch branch;

    public Account(Branch branch) {
        this.branch = branch;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be a positive number");
        }

        transactions.add(new Transaction(amount));
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be a positive number");
        }

        if (getBalance() < amount) {
            throw new IllegalStateException("Amount must not exceed the balance");
        }

        transactions.add(new Transaction(amount * -1));
    }

    public double getBalance() {
        BigDecimal sum = transactions.stream()
                .map(transaction -> BigDecimal.valueOf(transaction.amount))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sum.doubleValue();
    }

    public String generateStatement() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        StringBuilder statementBuilder = new StringBuilder();

        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.amount;
            String formattedAmount = String.format("%.2f", Math.abs(transaction.amount));
            String formattedBalance = String.format("%.2f", balance);
            String transactionLine = transaction.dateTime.format(formatter) + " || "
                    + (transaction.amount >= 0 ? formattedAmount + "  ||        || " : "       || "
                    + formattedAmount + "  || ") + formattedBalance;
            statementBuilder.insert(0, transactionLine).insert(0, "\n");
        }
        statementBuilder.insert(0, "date || credit || debit || balance");

        return statementBuilder.toString();
    }
}
