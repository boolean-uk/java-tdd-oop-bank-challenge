package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private List<Transaction> transactions = new ArrayList<>();
    private Branch branch;
    private Customer customer;
    public double overDrawAmount = 0;

    public Account(Branch branch){
        this.branch = branch;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void deposit(double amount) {
        transactions.add(new Transaction(amount, "DEPOSIT"));
    }

    public void withdraw(double amount) {
        if (amount > getBalance() + overDrawAmount) {
            System.out.println("Can not withdraw from account");
        } else {
            transactions.add(new Transaction(-amount, "WITHDRAWAL"));
        }
    }
    public String setOverDrawAmount(double overDrawAmount){
        if (overDrawAmount > getBalance() + overDrawAmount){
            System.out.println("Insufficient Balance");
        } else {
        this.overDrawAmount = overDrawAmount;
        return "New over draw amount: " +overDrawAmount;
    }
        return "OK";
    }

    public double getBalance() {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Branch getBranch() {
        return branch;
    }

    public Customer getCustomer(){
        return customer;
    }
}
