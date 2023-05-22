package com.booleanuk.core;

import java.util.Map;

public class Account {
    private String accountNumber;
    private double balance;
    private String accountType;
    private String customerId;
    private int id;

    //Arraylist<BankStatements> bankStatements;


    // constructor
    public Account(String accountNumber, double formerDeposit, String accountType) {
        this.setAccountNumber(accountNumber);
        this.setBalance(formerDeposit);
        this.setAccountType(accountType);
        this.setCustomerId(getCustomerId());
        //this.bankStatements = new ArrayList<>();
    }

//     formerDeposit method
    public void formerDeposit(double formerDeposit) {
       if (formerDeposit > 0.0) {
           balance += formerDeposit;
           System.out.println("You have successfully added " + formerDeposit + " to your account.");
           System.out.println("The new balance of your checking account is: " + balance);
       } else {
           balance = 0.0;
       }
    }

    // withdraw method
    public boolean withdraw(double amount) {
        double newBalance = balance - amount;
        if (newBalance < 0.0) {
            System.out.println("There is not enough money on your account.");
            return false;
        }
        balance = newBalance;
//        System.out.println("Your balance is: $" + balance);
        System.out.println("You have successfully removed $" + amount + " from your account.");
        System.out.println("The new balance of your checking account is: $" + getBalance());
        return true;
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

//    public Map<Object, Object> getTransactions() {
//    }
}
