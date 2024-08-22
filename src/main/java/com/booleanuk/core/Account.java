package com.booleanuk.core;

import java.util.Date;

public interface Account {
//    double balance = 0;

    String getRecords();
    boolean deposit(double amount, Date date);
    boolean withdraw(double amount, Date date);

    boolean requestOverdraft();
    double getBalance();
    void setBalance(double balance);


}
