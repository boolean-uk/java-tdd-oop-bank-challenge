package com.booleanuk.core;

public abstract class BankAccount {

    public String generateBankStatement(){
        return "";
    }

    public void depositMoney(double amount){
    }

    public void withdrawMoney(double amount){
    }

    private double calculateBalance(){
        return 0;
    }

    public void requestOverdraft(double amount){}

}
