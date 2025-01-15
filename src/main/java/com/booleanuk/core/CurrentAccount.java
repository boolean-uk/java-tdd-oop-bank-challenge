package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentAccount extends BankAccount{
    private Integer uniqueBankNumber;
    private Double balance;
    private ArrayList<Transaction> listOfTransactions;
    private Integer branchID;

    public CurrentAccount(Integer uniqueBankNumber, ArrayList<Transaction> listOfTransactions, Integer branchID){
        super(uniqueBankNumber, listOfTransactions, branchID);
    }

    public CurrentAccount(Integer uniqueBankNumber, Integer branchID){
        super(uniqueBankNumber, branchID);
    }
}
