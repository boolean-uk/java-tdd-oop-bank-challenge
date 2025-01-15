package com.booleanuk.core;

import java.util.ArrayList;

public class CurrentAccount extends BankAccount{
    private Integer uniqueBankNumber;
    private Double balance;
    private ArrayList<Transaction> listOfTransactions;

    public CurrentAccount(Integer uniqueBankNumber, Double balance, ArrayList<Transaction> listOfTransactions){
        super(uniqueBankNumber, balance, listOfTransactions);
    }

    public CurrentAccount(Integer uniqueBankNumber, Double balance){
        super(uniqueBankNumber, balance);
    }
}
