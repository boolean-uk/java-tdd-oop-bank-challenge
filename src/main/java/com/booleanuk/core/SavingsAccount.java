package com.booleanuk.core;

import java.util.ArrayList;

public class SavingsAccount implements Account{
    private ArrayList<Transaction> transactions;
    private int uniqueID;
    private String branch;
    private double balance;

    public SavingsAccount(String branch, int uniqueID){
        this.branch = branch;
        this.uniqueID = uniqueID;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }



    public double newTransaction(double depositAmount, double withdrawAmount){
        Transaction t = new Transaction(depositAmount, withdrawAmount);

        transactions.add(t);

        double newBalance = calculateAccountBalance();
        return newBalance;
    }

    private double calculateAccountBalance(){
        double totalDeposit = 0;
        double totalWithdraw = 0;
        for (Transaction t: transactions){
            totalDeposit += t.getDepositAmount();
            totalWithdraw += t.getWithdrawAmount();
        }

        double newTotal = totalDeposit - totalWithdraw;
        return newTotal;
    }

    public String generateStatement(){
        return "";

    }


    public double getBalance(){
        return calculateAccountBalance();

    }
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }


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
