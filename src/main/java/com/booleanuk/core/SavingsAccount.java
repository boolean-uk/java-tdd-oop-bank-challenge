package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccount implements BankAccount{
    private List<Transaction> transactions;
    private double balance;

    // Constructors
    public SavingsAccount(){
        this.transactions = new ArrayList<>();
    }

    public SavingsAccount(double balance){
        this.transactions = new ArrayList<>();
        setBalance(balance);
    }

    // Getters & Setters
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public double getBalance() {
        return this.balance;
    }

    // Methods
    public void makeTransaction(Transaction transaction) {
        if(transaction.getType().equals("deposit")){
            setBalance(getBalance() + transaction.getAmount());
            getTransactions().add(0,transaction);
        } else if(transaction.getType().equals("withdraw") && getBalance() >= transaction.getAmount()){
            setBalance(getBalance() - transaction.getAmount());
            getTransactions().add(0,transaction);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public boolean printStatement(){
        System.out.printf("| %-10s | %-8s | %-8s | %4s |%n", "date", "credit", "debit", "balance");

        for(Transaction transaction : getTransactions()) {
            if(transaction.getType().equals("deposit")) {
                System.out.printf("| %-10s | %-8s | %-8s | %4s |%n", transaction.getDate(),transaction.getAmount(), "", getBalance());
            } else if(transaction.getType().equals("withdraw")) {
                System.out.printf("| %-10s | %-8s | %-8s | %4s |%n", transaction.getDate(),"", transaction.getAmount(), getBalance());
            }
        }
        return false;
    }
}