package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);

            double balance = this.getBalance();
            Transaction transaction = new Transaction(formattedDateTime, depositAmount, balance);
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
            Transaction transaction = new Transaction(formattedDateTime, withdrawAmount, balance);
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
        System.out.printf("%-25s %-20s %-25s%n", "Transaction Date", "Transaction Amount", "Balance before transaction");
        System.out.println("---------------------------------------------------------------");

        for (Transaction transaction : this.transactions) {
            System.out.printf("%-25s %-20.2f %-25.2f%n",
                    transaction.getTransactionDate(),
                    transaction.getTransactionAmount(),
                    transaction.getBalanceAtTransaction());
        }
    }

}
