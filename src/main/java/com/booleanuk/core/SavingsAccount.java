package com.booleanuk.core;

import java.util.ArrayList;

public class SavingsAccount implements Account{
    private ArrayList<Transaction> transactions;
    private int uniqueID;
    private String branch;

    public SavingsAccount(String branch, int uniqueID){
        this.branch = branch;
        this.uniqueID = uniqueID;
    }

    /*

    public double newTransaction(Transaction transaction){

    }
    public String generateStatement(){

    }
    public double getBalance(){

    }
    public boolean setBalance(){

    }
    public ArrayList<Transaction> getTransactions(){

    }

     */

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "transactions=" + transactions +
                ", uniqueID=" + uniqueID +
                ", branch='" + branch + '\'' +
                '}';
    }
}
