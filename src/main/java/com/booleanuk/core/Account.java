package com.booleanuk.core;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Account {
    protected Customer customer;
    protected double balance;
    protected List<Transactions> transactions;
    protected String type;

    protected int limit;

    final int customerID;

    public Account(Customer customer) {
        this.customer = customer;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        this.limit= 0;
        this.customerID=customer.getCustomerID();

    }

    public Customer getCustomer() {
        return customer;
    }

    public int getLimit() {
        return limit;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }


    public double getBalance() {
        return balance;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public String deposit(double amount, Customer customer) {
        if (amount>0 & this.customerID == customer.getCustomerID()){
            balance +=amount;
            transactions.add(new Transactions(amount,getBalance()));
            System.out.println("Current balance : "+getBalance());
            return "Current balance : "+getBalance();
        }
        if (this.customerID != customer.getCustomerID()){
            System.out.println("Not your account");
            return "Not your account";
        }
        System.out.println("Can't deposit 0 or negative amount");
        return "Can't deposit 0 or negative amount";

    }


    public String withdraw(double amount, Customer customer) {
        if (balance - amount >= limit & this.customerID == customer.getCustomerID()){
            balance -= amount;
            transactions.add(new Transactions(-amount,getBalance()));
            System.out.println("Current balance : "+getBalance());
            return "Current balance : "+getBalance();
        }
        if (this.customerID != customer.getCustomerID()){
            System.out.println("Not your account");
            return "Not your account";
        }
        System.out.println("Can't withdraw more money than you have or pass your limit");
        return "Can't withdraw more money than you have or pass your limit";

    }

    public void printStatement2() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        System.out.printf("%-11s|| %-8s|| %-8s|| %-8s%n", "Date", "Credit", "Debit", "Balance");
        System.out.println("----------------------------------------");

        Collections.reverse(transactions);

        for (Transactions transaction : transactions) {
            String date = transaction.getTimestamp().toString();
            String credit = "";
            String debit = "";

            if (transaction.getAmount() > 0) {
                credit = decimalFormat.format(transaction.getAmount());
            } else {
                debit = decimalFormat.format(-transaction.getAmount());
            }

            String balance = decimalFormat.format(transaction.getBalance());

            System.out.printf("%-11s|| %-8s|| %-8s|| %-8s%n", date, credit, debit, balance);
        }
        Collections.reverse(transactions);
    }



}