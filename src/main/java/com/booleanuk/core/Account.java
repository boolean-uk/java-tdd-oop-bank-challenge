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
        transaction.setBalance(getBalance());
    }

    public double getBalance() {
        int balance = 0;
        for (Transaction transactions : transactions ) {
            if(transactions.getIsCredit()) {
               balance += (int) (transactions.getAmount() * 100);
            } else {
                balance -= (int) (transactions.getAmount() * 100);
            }
        }
        return balance / 100.0;
    }

    public void printStatement() {
        System.out.println("date       || credit  || debit  || balance");
        for (Transaction transaction : this.getTransactions()) {
            System.out.println(transaction);
        }
    }

}
