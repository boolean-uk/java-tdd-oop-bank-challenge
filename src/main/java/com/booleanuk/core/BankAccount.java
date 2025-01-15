package com.booleanuk.core;

import java.util.ArrayList;

public class BankAccount {
    private Integer uniqueBankNumber;
    private Double balance;
    private ArrayList<Transaction> listOfTransactions;

    public BankAccount(Integer uniqueBankNumber, Double balance, ArrayList<Transaction> listOfTransactions){
        this.uniqueBankNumber = uniqueBankNumber;
        this.balance = balance;
        this.listOfTransactions = listOfTransactions;
    }

    public BankAccount(Integer uniqueBankNumber, Double balance){
        this.uniqueBankNumber = uniqueBankNumber;
        this.balance = balance;
        this.listOfTransactions = new ArrayList<Transaction>();
    }
}
