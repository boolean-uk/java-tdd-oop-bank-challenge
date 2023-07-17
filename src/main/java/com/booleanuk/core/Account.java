package com.booleanuk.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

public class Account {
    private String accountNumber;
    private double balance;
    private String accountType;
    private String customerId;
    private int id;

    ArrayList<String> transactions;

    // constructor
    public Account(String accountNumber, double formerDeposit, String accountType) {
        this.setAccountNumber(accountNumber);
        this.setBalance(formerDeposit);
        this.setAccountType(accountType);
        this.setCustomerId(getCustomerId());
        this.transactions = new ArrayList<>();
    }

//     formerDeposit method
    public void formerDeposit(double formerDeposit, LocalDate localDate) {
       if (formerDeposit > 0.0) {
           balance += formerDeposit;
           String transaction = localDate + " || " + formerDeposit + " ||      || " + balance;
           this.transactions.add(transaction);
           System.out.println("You have successfully added " + formerDeposit + " to your account.");
           System.out.println("The new balance of your checking account is: " + balance);
       } else {
           balance = 0.0;
       }
    }

    // withdraw method
    public boolean withdraw(double amount, LocalDate localDate) {
        double newBalance = balance - amount;
        if (newBalance < 0.0) {
            System.out.println("There is not enough money on your account.");
            return false;
        }
        balance = newBalance;
        String transaction = localDate + " ||      || " + amount + " || "  + balance;
        this.transactions.add(transaction);
        System.out.println("You have successfully removed $" + amount + " from your account.");
        System.out.println("The new balance of your checking account is: $" + getBalance());
        return true;
    }

    public String printStatement() {
        String listTransactions = " date   ||  credit  ||  debit || balance " + "\n";
      for (String transactionsValues : this.transactions) {
          listTransactions += transactionsValues + "\n";
      }
      return listTransactions;
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
