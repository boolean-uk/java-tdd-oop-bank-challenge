package com.booleanuk.core;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final LocalDate date;
    private final double amount;
    private final double balance;

    public Transaction(double amount, double balance) {
        this.date = LocalDate.now();
        this.amount = amount;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String credit = amount > 0 ? String.format("%.2f", amount) : "";
        String debit = amount < 0 ? String.format("%.2f", Math.abs(amount)) : "";

        return String.format("%-10s || %-6s || %-6s || %-6s",
                date.format(formatter),
                credit,
                debit,
                String.format("%.2f", balance)
        );
    }
}
