package com.booleanuk.core;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDate date;
    private double amount;
    private double balance;

    public Transaction(double amount, double balance) {
        this.date = LocalDate.now();
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String credit = amount > 0 ? String.format("%.2f", amount) : "";
        String debit = amount < 0 ? String.format("%.2f", Math.abs(amount)) : "";

        String title = "\t ~~~~ TRANSACTION HISTORY ~~~~ ";
        String columnsTitle = String.format("%-10s || %-6s || %-6s || %-6s", "date", "credit", "debit", "balance");
        String transactionDetails = String.format("%-10s || %-6s || %-6s || %-6s",
                date.format(formatter),
                credit,
                debit,
                String.format("%.2f", balance)
        );

        return title + "\n".repeat(2) + columnsTitle + "\n" + transactionDetails;
    }

    public static void main(String[] args) {

        Transaction transaction = new Transaction(100.0, 400.0);
        System.out.println(transaction);
    }
}
