package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Account {
   private Branch branch;
    private String accountNumber;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private LocalDateTime date = LocalDateTime.now();

    public Account(String accountNumber, Branch branch) {
       this.accountNumber = accountNumber;
       this.branch = new Branch(branch.getBranchId());
    }

    abstract public void deposit(int amount);
    abstract public void withdraw(int amount);

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(int amount, boolean isCredit) {
        Transaction transaction = new Transaction(date, amount ,isCredit);
        transactions.add(transaction);
    }

    public double getBalance() {
        return 0.0;
    }

}
