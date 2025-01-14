package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Account {
    private String branch;
    private String accountType;
    private boolean overDraftEnabled;
    private double overDraftLimit;
    ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String accountType, String branch) {
        this.branch = branch;
        if(Objects.equals(accountType, "Current")){
            this.overDraftEnabled = false;
            this.overDraftLimit = 0.0;

        }else if(Objects.equals(accountType, "Saving")){
            this.overDraftEnabled = false;
            this.overDraftLimit = 0.0;
        }
    }




    public void depositFunds(double depositAmount){
        if(depositAmount > 0){
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);

            double balance = this.getBalance();
            Transaction transaction = new Transaction(formattedDateTime, depositAmount, balance + depositAmount);
            this.transactions.add(transaction);
        }else{
            System.out.println("You cannot deposit a 0 or negative amount.");
        }

    }

    public void withdrawFunds(double withdrawAmount){
        if(withdrawAmount < 0){
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            double balance = this.getBalance();
            Transaction transaction = new Transaction(formattedDateTime, withdrawAmount, balance + withdrawAmount);
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
        System.out.printf("%-25s %-20s %-25s%n", "Transaction Date", "Transaction Amount", "Balance");
        System.out.println("---------------------------------------------------------------");

        for (Transaction transaction : this.transactions) {
            System.out.printf("%-25s %-20.2f %-25.2f%n",
                    transaction.getTransactionDate(),
                    transaction.getTransactionAmount(),
                    transaction.getBalanceAtTransaction());
        }
    }

    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    public boolean isOverDraftEnabled() {
        return overDraftEnabled;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getBranch() {
        return branch;
    }
}
