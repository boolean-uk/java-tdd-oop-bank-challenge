package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private List<Transaction> transactionHistory;
    private Branch branch;
    public BankAccount(String accountNumber,Branch branch) {
        this.accountNumber = accountNumber;
        this.transactionHistory = new ArrayList<>();
        this.branch = branch;
        branch.addAccount(this);
    }

    public Branch getBranch() {
        return branch;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(BigDecimal amount, String date, String type) {
        transactionHistory.add(new Transaction(date, amount,type));
    }

    public void withdraw(BigDecimal amount, String date, String type) {
        transactionHistory.add(new Transaction(date, amount.negate(),type));
    }

    public BigDecimal getBalance() {
        BigDecimal balance = new BigDecimal("0.00");
        for (Transaction transaction : transactionHistory) {
            balance = balance.add(transaction.getAmount());
        }
        return balance;
    }


}
