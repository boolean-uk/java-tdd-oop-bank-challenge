package com.booleanuk.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
    final static String POUND = "\u00a3";
    float balance;
    List<Transaction> transactionsHistory;

    public Account() {
        transactionsHistory = new ArrayList<>();
    }

    public float getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionsHistory() {
        return transactionsHistory;
    }

    public String deposit(float amount, LocalDate date) {
        if (amount > 0) {
            if (transactionsHistory.size() == 0 || date.isAfter(transactionsHistory.get(transactionsHistory.size() - 1).getDate())) {
                balance += amount;
                transactionsHistory.add(new Transaction(date, amount));
                return amount + POUND + " deposited into your account.";
            } else {
                return "You cannot deposit any money before the last date in transactions history.";
            }
        } else return "Amount is invalid";
    }

    public String withdraw(float amount, LocalDate date) {

        if (amount > 0) {
            if (amount < balance) {
                if (transactionsHistory.size() == 0
                        || (date.isAfter(transactionsHistory.get(transactionsHistory.size() - 1).getDate())
                        || date.isEqual(transactionsHistory.get(transactionsHistory.size() - 1).getDate()))) {
                    balance -= amount;
                    transactionsHistory.add(new Transaction(date, amount * -1));
                    return amount + POUND + " withdrawn from your account.";

                } else return "You cannot withdraw any money before the last date in transactions history.";
            } else return "You do not have enough money in your account.";
        } else return "Amount is invalid.";
    }

    public String generateBankStatement() {
        StringBuilder builder = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        float balance = 0;
        String header = String.format("%-13s || %-10s || %-10s || %-10s\n", " date", "credit", "debit", "balance");
        builder.insert(0, header);
        builder.insert(56, "   ");

        Transaction transaction;
        for (int i = 0; i < transactionsHistory.size(); i++) {
            transaction = transactionsHistory.get(i);
            if (transaction.getAmount() > 0) {
                balance += transaction.getAmount();
                builder.insert(header.length() + transactionsHistory.size() - i, String.format("%-12s || %-10.2f || %-10s || %.2f\n", transaction.getDate().format(formatter), transaction.getAmount(), " ", balance));
            } else {
                balance += transaction.getAmount();
                builder.insert(header.length() + transactionsHistory.size() - i, String.format("%-12s || %-10s || %-10.2f || %.2f\n", transaction.getDate().format(formatter), " ", Math.abs(transaction.getAmount()), balance));
            }
        }
        return builder.toString();
    }
}
