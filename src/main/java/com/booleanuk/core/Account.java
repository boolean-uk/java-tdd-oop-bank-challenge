package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class Account {
    private String branch;
    private String accountType;
    private boolean overDraftEnabled;
    private double overDraftLimit;
    ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {

    }




    public void depositFunds(double depositAmount){
        if(depositAmount > 0){
            LocalDateTime currentDateTime = LocalDateTime.now();
            double balance = this.getBalance();
            Transaction transaction = new Transaction(currentDateTime.toString(), depositAmount, balance);
            this.transactions.add(transaction);
        }else{
            System.out.println("You cannot deposit a 0 or negative amount.");
        }

    }

    public void withdrawFunds(double withdrawAmount){
        if(withdrawAmount < 0){
            LocalDateTime currentDateTime = LocalDateTime.now();
            double balance = this.getBalance();
            Transaction transaction = new Transaction(currentDateTime.toString(), withdrawAmount, balance);
            this.transactions.add(transaction);
        }else{
            System.out.println("You cannot withdraw a 0 or positive amount.");
        }
    }

    public double getBalance() {
        double balance = 0.0;
        for (Transaction transaction : this.transactions) {
            balance += transaction.getTransactionAmount();
        }
        return balance;
    }

    public void generateStatement(){

    }

}
