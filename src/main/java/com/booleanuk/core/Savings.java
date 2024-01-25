package com.booleanuk.core;

public class Savings implements Account {

    //String accountNumber, String name, double balance
    private String accountNumber;
    private String name;
    private double balance;
    private boolean overDraft;



    public Savings(String accountNumber, String name, double balance) {

        this.setAccountNumber(accountNumber);
        this.setName(name);
        this.setBalance(balance);
        this.overDraft = false;



    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setOverDraftTrue() {
        this.overDraft = true;
    }

    public boolean isOverDraft() {
        return overDraft;
    }

    public void setOverDraftFalse() {
        this.overDraft = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}