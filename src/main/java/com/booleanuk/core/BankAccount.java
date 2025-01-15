package com.booleanuk.core;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BankAccount {
    private Integer uniqueBankNumber;
    private Double balance;
    private ArrayList<Transaction> listOfTransactions;

    public BankAccount(Integer uniqueBankNumber, ArrayList<Transaction> listOfTransactions){
        this.uniqueBankNumber = uniqueBankNumber;

        Double totalBalance = 0D;
        for(Transaction transaction : listOfTransactions){
            totalBalance += transaction.getAmount();
        }

        this.balance = Math.round(totalBalance * 100.0) / 100.0;
        this.listOfTransactions = listOfTransactions;
    }

    public BankAccount(Integer uniqueBankNumber){
        this.uniqueBankNumber = uniqueBankNumber;
        this.balance = 0D;
        this.listOfTransactions = new ArrayList<Transaction>();
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getUniqueBankNumber() {
        return uniqueBankNumber;
    }

    public ArrayList<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public Double makeDeposit(Double amount, LocalDateTime dateTime){
        if((this.balance + amount) > this.balance){
            Transaction deposit = new Transaction(dateTime, amount, "Deposit");
            this.listOfTransactions.add(deposit);
            this.balance += amount;
        }
        return this.balance;
    }

    public Double makeWithDraw(Double amount, LocalDateTime dateTime){
        if((this.balance + amount) < this.balance){
            Transaction withdraw = new Transaction(dateTime, amount, "Withdraw");
            this.listOfTransactions.add(withdraw);
            this.balance += amount;
        }
        return this.balance;
    }
}
