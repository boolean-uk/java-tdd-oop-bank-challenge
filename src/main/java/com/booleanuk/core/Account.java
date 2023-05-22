package com.booleanuk.core;

public class Account {
    private String accountNumber;
    private int balance;
    private String accountType;
    private String customerId;
    private int id;
    //Arraylist<BankStatements> bankStatements;


    // constructor
    public Account(String accountNumber, int formerDeposit, String accountType) {
        this.setAccountNumber(accountNumber);
        this.setBalance(formerDeposit);
        this.setAccountType(accountType);
        this.setCustomerId(getCustomerId());
        //this.bankStatements = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
