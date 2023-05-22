package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class SavingsAccount implements BankAccount{

    private List<Transaction> transactions;
    private final Branch branch;
    private double startAmount;
    private double balance;

    //Constructors
    public SavingsAccount(Branch branch, double startAmount) {
        this.branch = branch;
        this.startAmount = startAmount;
        this.transactions = new ArrayList<>();
    }

    public SavingsAccount(Branch branch){
        this.branch = branch;
        this.transactions = new ArrayList<>();
    }

    // Getters & Setters
    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    @Override
    public boolean HasOverdraft() {
        return false;
    }

    @Override
    public double getOverdraft() {
        return 0;
    }

    @Override
    public void setHasOverdraft(boolean bool) {

    }

    @Override
    public void setOverdraft(double overdraft) {

    }

    public double getBalance() {
        double balance = this.startAmount;
        for (Transaction transaction : this.transactions) {
            if (transaction.getType().equals("deposit")) {
                balance += transaction.getAmount();
            } else if (transaction.getType().equals("withdraw")) {
                balance -= transaction.getAmount();
            }
        }
        return this.balance = balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    // Methods
    public boolean printStatement() {
        System.out.println("Bank Statement Savings Account");
        System.out.printf("| %-10s | %-8s | %-8s | %4s |%n", "date", "credit", "debit", "balance");

        for(Transaction transaction : getTransactions()) {
            if(transaction.getType().equals("deposit")) {
                System.out.printf("| %-10s | %-8s | %-8s | %4s |%n", transaction.getDate(),transaction.getAmount(), "", transaction.getBalance());
            } else if(transaction.getType().equals("withdraw")) {
                System.out.printf("| %-10s | %-8s | %-8s | %4s |%n", transaction.getDate(),"", transaction.getAmount(), transaction.getBalance());
            }
        }
        System.out.printf("| %-10s | %-8s | %-8s | %4s |%n", "", "", "", startAmount);
        System.out.println("\n");
        return true;
    }

}