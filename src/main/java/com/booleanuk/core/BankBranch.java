package com.booleanuk.core;

public class BankBranch {
    public int createAccount(boolean isCurrentAccount){
        return 0;
    }

    public String getBankStatement(int accountNumber){
        return "";
    }

    public void depositMoney(int accountNumber, double amount){

    }

    public void withdrawMoney(int accountNumber, double amount){

    }

    public void requestOverdraft(int accountNumber, double amount) {

    }

    public BankAccount getAccount(int accountNumber){
        return new SavingsAccount();
    }
}
