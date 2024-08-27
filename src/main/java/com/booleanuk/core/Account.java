package com.booleanuk.core;

import java.util.ArrayList;

public interface Account {


    public double newTransaction(double depositAmount, double withdrawAmount, int transactionID);
    public String generateAccountStatement();
    public void requestOverdraft(double overdraftAmount);
    public double getBalance();
    public double calculateAccountBalance();
    public void setBalance(double newBalance);
    public void setOverdraftAmount(Double overdraftAmount);

    public int getUniqueID();

    public ArrayList<Transaction> getTransactions();

}
