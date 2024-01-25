package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private Branch branch;
    private int accountNumber;
    private Person accountOwner;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(Branch branch, int accountNumber, Person accountOwner, double balance) {
        this.setBranch(branch);
        this.setAccountNumber(accountNumber);
        this.setAccountOwner(accountOwner);
        this.setBalance(balance);
        this.setTransactionHistory();
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Person getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(Person accountOwner) {
        this.accountOwner = accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory() {
        this.transactionHistory = new ArrayList<Transaction>();
    }
}
