package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class BankAccount {
    List<Transaction> transactions = new ArrayList<>();
    protected String accountNumber;
    private String branchCode;
    protected final int accountHolderID;

    protected BankAccount(String accountNumber, int accountHolderID, String branchCode) {
        this.accountNumber = accountNumber;
        this.accountHolderID = accountHolderID;
        this.branchCode = branchCode;

    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0.0d) {
            throw new IllegalArgumentException("Cannot deposit a negative amount");
        }
        transactions.add(new Transaction(getBalance() + amount, LocalDateTime.now(), TransactionType.CREDIT, amount));
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount < 0.0d) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount");
        }
        if (amount > getBalance()) {
            throw new IllegalArgumentException("Cannot withdraw more than the balance");
        }
        transactions.add(new Transaction(getBalance() - amount, LocalDateTime.now(), TransactionType.DEBIT, amount));
    }


    public double getBalance() {
        double balance = 0.0d;
        transactions.sort(Comparator.comparing(Transaction::transactionDate));
        for (Transaction transaction : transactions) {
            if (transaction.type() == TransactionType.CREDIT) {
                balance += transaction.amount();
            } else {
                balance -= transaction.amount();
            }
        }
        return balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public int getAccountHolderID() {
        return this.accountHolderID;
    }

}
