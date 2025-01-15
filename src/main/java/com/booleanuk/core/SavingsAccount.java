package com.booleanuk.core;

import java.util.ArrayList;

public class SavingsAccount extends BankAccount{
    private Integer uniqueBankNumber;
    private Double balance;
    private ArrayList<Transaction> listOfTransactions;

    public SavingsAccount(Integer uniqueBankNumber, ArrayList<Transaction> listOfTransactions){
        super(uniqueBankNumber, listOfTransactions);
    }

    public SavingsAccount(Integer uniqueBankNumber){
        super(uniqueBankNumber);
    }
}
