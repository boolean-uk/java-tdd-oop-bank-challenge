package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Account {
    private final String accountNumber;
    private final List<Transaction> transactions;
    private Branch branch;

    public Account(){
        this.accountNumber = UUID.randomUUID().toString();
        this.transactions = new ArrayList<>();
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Branch getBranch() {
        return branch;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }

    public OverdraftRequest getOverdraftRequest(){
        return null;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
