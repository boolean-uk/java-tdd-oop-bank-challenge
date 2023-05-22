package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SavingsAccount implements BankAccount{
    private static int ACCOUNT_NUMBER = 0000;

    private int accountNumber;
    private List<Transaction> transactions;
    private double startAmount;
    private double balance;

    //Constructors
    public SavingsAccount(double startAmount) {
        this.accountNumber = ACCOUNT_NUMBER++;
        this.startAmount = startAmount;
        this.transactions = new ArrayList<>();
    }

    public SavingsAccount(){
        this.accountNumber = ACCOUNT_NUMBER++;
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