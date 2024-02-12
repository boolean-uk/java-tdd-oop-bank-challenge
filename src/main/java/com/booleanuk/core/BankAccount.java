package com.booleanuk.core;

import java.util.ArrayList;

public class BankAccount {

    private String accountHolder;
    private String accountNumber;
    private String accountType;
    private BankBranch accountBranch; //Extension User Story 2
    private double overdraftLimit; //Extension User Story 3 and 4
    private double balance;

    private ArrayList<Transaction> transactionList;

    public BankAccount() {
        transactionList = new ArrayList<>();
    }

    public BankAccount(String accountHolder, String accountNumber, String accountType, BankBranch accountBranch, double overdraftLimit, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBranch = accountBranch;
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
        this.transactionList = new ArrayList<>();
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    //Extension User Story 2 -----/
    public BankBranch getAccountBranch() {
        return accountBranch;
    }

    public void setBranch(BankBranch accountBranch) {
        this.accountBranch = accountBranch;
    }
    //-----------------------------/

    //Extension User Story 1
    public double getBalance() {
        double balance = this.balance;
        for (Transaction transaction : transactionList) {
            if (transaction.getType().equals("Deposit")) {
                balance += transaction.getAmount();
            } else if (transaction.getType().equals("Withdrawal")) {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }

    //Extension User Story 3
    public boolean requestOverdraft(double limit) {
        this.overdraftLimit = limit;
        return true; //Approved
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
