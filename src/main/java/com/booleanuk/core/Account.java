package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public abstract class Account {
    private double balance;
    //private HashMap<String, double[]> bankStatement=new HashMap<>();
    private ArrayList<String[]> transactionHistory=new ArrayList<>();
    protected boolean overdraftRequest=false;
    protected boolean overdraft=false;
    String branch;

    public Account(double amount, String branch){
        this.branch=branch;
        if(amount>0){
            balance=amount;
        }
        else{
            amount=0;
        }

    }

    public boolean deposit(double amount, String time){
        balance+=amount;
        //bankStatement.put(time, new double[]{amount, balance});
        //String.valueOf(amount);
        transactionHistory.add(new String[]{time, String.valueOf(amount), String.valueOf(balance)});
        return true;
    }

    public boolean withdraw(double amount, String time){
        if (amount<balance | (overdraft & balance-amount>=-1000)){
            balance-=amount;
            //bankStatement.put(time, new double[]{-amount, balance});
            transactionHistory.add(new String[]{time, String.valueOf(-amount), String.valueOf(balance)});
            return true;
        }else{
            System.out.println("Unable to withdraw more money.");
            return false;
        }

    }


    public double calculateBalance(){
        double findBalance=0;

        for (int i=0; i<transactionHistory.size();i++) {
            findBalance+=Double.parseDouble(transactionHistory.get(i)[1]);
        }

        balance=findBalance;
        return findBalance;
    }



    public void generateBankStatement(){
        System.out.println("date       || credit || debit || balance");
        String info;
        for (int i=transactionHistory.size()-1; i>=0; i--){
            double direct=Double.parseDouble(transactionHistory.get(i)[1]);
            if(direct>0){
                info=("|| "+ direct+" ||       || "+transactionHistory.get(i)[2]);
            }
            else{
                info=("||        || "+ -direct+" || "+transactionHistory.get(i)[2]);
            }

            System.out.println(transactionHistory.get(i)[0]+" "+info);

        }
    }

    public double getBalance() {
        return balance;
    }



    public String getBranch() {
        return branch;
    }


}
