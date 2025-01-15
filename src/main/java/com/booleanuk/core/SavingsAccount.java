package com.booleanuk.core;

import java.util.ArrayList;

public class SavingsAccount extends BankAccount{
    private Integer uniqueBankNumber;
    private Double balance;
    private ArrayList<Transaction> listOfTransactions;

    public SavingsAccount(Integer uniqueBankNumber, Double balance, ArrayList<Transaction> listOfTransactions){
        super(uniqueBankNumber, balance, listOfTransactions);
    }

    public SavingsAccount(Integer uniqueBankNumber, Double balance){
        super(uniqueBankNumber, balance);
    }
}
