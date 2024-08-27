package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Account implements Depositable {
    protected ArrayList<Transaction> transactions;
    protected String ownerId;
    protected String branchId;
    protected String accountId;

    public abstract String transfer(String targetAccountId, int sum);

    @Override
    public void deposit(Transaction transaction) {
        transactions.add(transaction);
    }

    public String getAccountId() {
        return accountId;
    }

    public int calculateBalance(int i) {
        LocalDateTime now = LocalDateTime.now().plusDays(i);
        int toTransactions = transactions.stream()
                .filter(transaction -> transaction.transactionTime().isBefore(now))
                .filter(transaction -> transaction.toAccount().equals(accountId))
                .mapToInt(Transaction::value).sum();
        int awayTransactions = transactions.stream()
                .filter(transaction -> transaction.transactionTime().isBefore(now))
                .filter(transaction -> transaction.fromAccount().equals(accountId))
                .mapToInt(Transaction::value).sum();
        return toTransactions - awayTransactions;
    }

    public static int calculateBalance(ArrayList<Transaction> transactions, String accountId, int i) {
        LocalDateTime now = LocalDateTime.now().plusDays(i);
        int toTransactions = transactions.stream()
                .filter(transaction -> transaction.transactionTime().isBefore(now))
                .filter(transaction -> transaction.toAccount().equals(accountId))
                .mapToInt(Transaction::value).sum();
        int awayTransactions = transactions.stream()
                .filter(transaction -> transaction.transactionTime().isBefore(now))
                .filter(transaction -> transaction.fromAccount().equals(accountId))
                .mapToInt(Transaction::value).sum();
        return toTransactions - awayTransactions;
    }

    public int calculateBalance() {
        return calculateBalance(0);
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
}
