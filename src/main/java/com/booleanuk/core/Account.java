package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Account implements Depositable {
    protected ArrayList<Transaction> transactions;
    protected String ownerId;
    protected String branchId;
    protected String accountId;

    public abstract int withdraw(int sum);
    public abstract int transfer(String targetAccountId, int sum);


    @Override
    public void deposit(int sum, LocalDateTime timeOfTransaction) {
        transactions.add(new Transaction(timeOfTransaction, "-1", this.accountId, sum));
    }

    @Override
    public void deposit(Transaction transaction) {
        transactions.add(transaction);
    }

    public String getAccountId() {
        return accountId;
    }

    public int calculateBalance() {
        LocalDateTime now = LocalDateTime.now();
        return transactions.stream().filter(transaction -> transaction.transactionTime().isBefore(now))
                .mapToInt(Transaction::value).sum();
    }
}
