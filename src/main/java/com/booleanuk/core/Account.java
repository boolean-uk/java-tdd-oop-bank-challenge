package com.booleanuk.core;

public interface Account {

    public double deposit(double amount);
    public double withdraw(double amount);
    public String transactionListToString();
    public double getBalance();



}
