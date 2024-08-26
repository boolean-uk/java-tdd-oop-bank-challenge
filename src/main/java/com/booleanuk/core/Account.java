package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public abstract class Account {
    private double balance;
    //private HashMap<String, double[]> bankStatement=new HashMap<>();
    private ArrayList<String[]> bankStatement=new ArrayList<>();
    private boolean overdraftRequest=false;
    private boolean overdraft=false;
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
        bankStatement.add(new String[]{time, String.valueOf(amount), String.valueOf(balance)});
        return true;
    }

    public boolean withdraw(double amount, String time){
        if (amount<balance | overdraft){
            balance-=amount;
            //bankStatement.put(time, new double[]{-amount, balance});
            bankStatement.add(new String[]{time, String.valueOf(-amount), String.valueOf(balance)});
            return true;
        }else{
            return false;
        }

    }


    public double calculateBalance(){
        double findBalance=0;

        for (int i=0; i<bankStatement.size();i++) {
            findBalance+=Double.parseDouble(bankStatement.get(i)[1]);
        }

        balance=findBalance;
        return findBalance;
    }



    public void generateBankStatement(){
        System.out.println("date       || credit || debit || balance");
        String info;
        for (int i=bankStatement.size()-1; i>=0; i--){
            double direct=Double.parseDouble(bankStatement.get(i)[1]);
            if(direct>0){
                info=("|| "+ direct+" ||       || "+bankStatement.get(i)[2]);
            }
            else{
                info=("||        || "+ -direct+" || "+bankStatement.get(i)[2]);
            }

            System.out.println(bankStatement.get(i)[0]+" "+info);

        }
    }

    public double getBalance() {
        return balance;
    }

    public void requestOverdraft(){
        overdraftRequest=true;
    }

    public boolean isOverdraftRequest() {
        return overdraftRequest;
    }

    public boolean isOverdraft() {
        return overdraft;
    }

    public boolean answerOverdraft(boolean answer){
        if (overdraftRequest){
            overdraft=answer;
            return true;
        }
        return false;
    }

    public String getBranch() {
        return branch;
    }


}
