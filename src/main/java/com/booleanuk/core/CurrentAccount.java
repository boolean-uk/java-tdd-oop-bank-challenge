package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentAccount extends BankAccount{
    private Integer uniqueBankNumber;
    private Double balance;
    private ArrayList<Transaction> listOfTransactions;
    private Integer bankID;

    public CurrentAccount(Integer uniqueBankNumber, ArrayList<Transaction> listOfTransactions, Integer bankID){
        super(uniqueBankNumber, listOfTransactions, bankID);
    }

    public CurrentAccount(Integer uniqueBankNumber, Integer bankID){
        super(uniqueBankNumber, bankID);
    }
}
