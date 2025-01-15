package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentAccount extends BankAccount{
    private Integer uniqueBankNumber;
    private Double balance;
    private ArrayList<Transaction> listOfTransactions;

    public CurrentAccount(Integer uniqueBankNumber, ArrayList<Transaction> listOfTransactions){
        super(uniqueBankNumber, listOfTransactions);
    }

    public CurrentAccount(Integer uniqueBankNumber){
        super(uniqueBankNumber);
    }
}
