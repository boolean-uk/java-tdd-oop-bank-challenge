package com.booleanuk.core;

public class Transaction {
    double amount;
    String dateTime;
    Customer customer;

    public Transaction(double amount, String dateTime, Customer customer) {
        this.amount = amount;
        this.dateTime = dateTime;
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
