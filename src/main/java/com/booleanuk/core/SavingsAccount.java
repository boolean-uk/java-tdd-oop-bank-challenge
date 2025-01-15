package com.booleanuk.core;

import java.util.ArrayList;

public class SavingsAccount extends BankAccount{
    private Integer uniqueBankNumber;
    private Double balance;
    private ArrayList<Transaction> listOfTransactions;
    private Integer branchID;

    public SavingsAccount(Integer uniqueBankNumber, ArrayList<Transaction> listOfTransactions, Integer branchID){
        super(uniqueBankNumber, listOfTransactions, branchID);
    }

    public SavingsAccount(Integer uniqueBankNumber, Integer branchID){
        super(uniqueBankNumber, branchID);
    }
}
