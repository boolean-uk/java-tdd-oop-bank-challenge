package com.booleanuk.core;

public abstract class BankAccount {

    public String generateBankStatement(){
        return "";
    }

    public void depositMoney(double amount){
    }

    public void withdrawMoney(double amount){
    }

    public double calculateBalance(){
        return -1;
    }

    public void requestOverdraft(double amount){}

}
