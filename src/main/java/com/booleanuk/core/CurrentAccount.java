package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;


public class CurrentAccount implements BankAccount{
    private static int ACCOUNT_NUMBER = 0;

    private int accountNumber;
    private final List<Transaction> transactions;
    private double startAmount;
    private double balance;
    private final Branch branch;
    private boolean hasOverdraft;
    private double overdraft;

    //Constructors
    public CurrentAccount(Branch branch, double startAmount) {
        this.accountNumber = ACCOUNT_NUMBER++;
        this.branch = branch;
        this.accountNumber = this.getAccountNumber();
        this.startAmount = startAmount;
        this.transactions = new ArrayList<>();
    }

    public CurrentAccount(Branch branch){
        this.branch = branch;
        this.accountNumber = ACCOUNT_NUMBER++;
        this.accountNumber = this.getAccountNumber() + 1;
        this.transactions = new ArrayList<>();
    }

    // Getters & Setters
    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
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

    public boolean HasOverdraft() {
        return this.hasOverdraft;
    }

    public void setHasOverdraft(boolean hasOverdraft) {
        this.hasOverdraft = hasOverdraft;
    }


    public void setOverdraft(double overdraft) {
      this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return this.overdraft;
    }

    // Methods
    public boolean printStatement() {
        System.out.println(branch.getName() + " " + branch.getLocation());
        System.out.println("Bank Statement Current Account");
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
