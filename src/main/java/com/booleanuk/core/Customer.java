package com.booleanuk.core;

public class Customer {
    private Account savingsAccount;
    private Account currentAccount;

    public Customer() {
    }

    public boolean createAccount(String type){
        return false;
    }

    public boolean deposit(Account account, double amount){
        return  false;
    }

    public boolean withdraw(Account account, double amount){
        return false;
    }

    public String generateBankStatement(Account account){
        return "";
    }
}
