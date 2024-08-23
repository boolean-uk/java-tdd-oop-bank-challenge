package com.booleanuk.core;

import java.util.HashMap;

public abstract class Account {
    private double balance;
    HashMap<String, double[]> bankStatement;
    boolean overdraftRequest=false;
    boolean overdraft;

    Account(double amount){
        balance=amount;
    }

    boolean deposit(double amount, String time){
        balance+=amount;
        bankStatement.put(time, new double[]{amount, balance});
        return true;
    }

    boolean withdraw(double amount, String time){
        if (amount<balance){
            balance-=amount;
            bankStatement.put(time, new double[]{-amount, balance});
            return true;
        }else{
            return false;
        }

    }

    void calculateBalance(){
        double findBalance=0;

        for (String time: bankStatement.keySet()) {
            findBalance+=bankStatement.get(time)[0];
        }

        balance=findBalance;
    }



}
