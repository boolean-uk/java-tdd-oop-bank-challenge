package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
    private int branchNr = 1;

    ArrayList<Customer> customers;
    ArrayList<Transaction> transactions;


    public Account createAcc(Customer customer,int choice){
        Account account = new Saving("Saving",0,customer);
        return account;
    }

    public String seeTransactions(Customer customer,int choice){
        String output = "1";
        return output;
    }

    public String makeDeposit(Customer customer,int choice,double balance){
        String output = "1";

        return output;
    }

    public String makeWithdraw(Customer customer,int choice,double balance){
        String output = "1";

        return output;
    }
}
