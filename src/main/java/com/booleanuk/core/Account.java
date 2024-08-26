package com.booleanuk.core;

import java.util.ArrayList;

public interface Account {


    public double newTransaction(double depositAmount, double withdrawAmount);
    public String generateStatement();
    public double getBalance();
    public void setBalance(double newBalance);



    public ArrayList<Transaction> getTransactions();

}
