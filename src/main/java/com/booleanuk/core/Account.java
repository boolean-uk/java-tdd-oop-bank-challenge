package com.booleanuk.core;

import java.util.ArrayList;

public interface Account {


    public double newTransaction(double depositAmount, double withdrawAmount, int transactionID);
    public String generateAccountStatement();
    public double getBalance();
    public void setBalance(double newBalance);



    public ArrayList<Transaction> getTransactions();

}
