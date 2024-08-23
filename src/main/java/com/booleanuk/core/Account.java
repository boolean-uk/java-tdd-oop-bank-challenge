package com.booleanuk.core;

import java.util.ArrayList;

public abstract class Account {
   private Branch branch;
    private String accountNumber;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, Branch branch) {
       this.accountNumber = accountNumber;
       this.branch = new Branch(branch.getBranchId());
    }

    abstract public void deposit(int amount);
    abstract public void withdraw(int amount);

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

}
