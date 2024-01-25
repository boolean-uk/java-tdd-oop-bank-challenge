package com.booleanuk.core;

public interface Account {
    double balance = 0;

    String getRecords();

    boolean deposit(double amount);
    boolean withdraw(double amount);
    double getBalance();
    void setBalance(double balance);


}
