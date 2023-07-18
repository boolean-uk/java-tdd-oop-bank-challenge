package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private double balance;
    private Customer customer;
    private List<Transaction> transactions;

    public Account(String accountNumber, Customer customer){
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }




}
