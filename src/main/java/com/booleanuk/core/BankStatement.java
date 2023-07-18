package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class BankStatement {
    private BankAccount account;
    List<Transaction> transactions;


    public BankStatement(BankAccount account) {
        this.account = account;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public BankAccount getAccount() {
        return account;
    }

    private int getCreditLineLength() {
        return transactions.stream()
                .filter(t -> t.type() == TransactionType.CREDIT)
                .map(t -> Math.round(t.amount() * 100) / 100)
                .map(String::valueOf).mapToInt(String::length)
                .max()
                .orElse(" credit ".length());
    }

    private int getDebitLineLength() {
        return transactions.stream()
                .filter(t -> t.type() == TransactionType.DEBIT)
                .map(t -> Math.round(t.amount() * 100) / 100)
                .map(String::valueOf).mapToInt(String::length)
                .max()
                .orElse(" debit ".length());
    }

    @Override
    public String toString() {
        int creditLineLength = getCreditLineLength();
        int debitLineLength = getDebitLineLength();
        StringBuilder sb = new StringBuilder();
        sb.append("date").append(" ".repeat(7)).append("||");
        sb.append(" credit ")
                .append(" ".repeat(Math.min(creditLineLength - " credit ".length(), 0)))
                .append("||");
        sb.append(" debit ")
                .append(" ".repeat(debitLineLength - " debit ".length()))
                .append("||");
        sb.append(" balance");
        sb.append(System.lineSeparator());


        for (Transaction transaction : transactions) {
            sb.append(transaction.transactionDate()).append(" || ");
            if (transaction.type() == TransactionType.CREDIT) {
                sb.append(transaction.amount()).append(" || ");
                sb.append(" ".repeat(9)).append(" || ");
            } else {
                sb.append(" ".repeat(9)).append(" || ");
                sb.append(transaction.amount()).append(" || ");
            }
            sb.append(transaction.balanceAfter());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
