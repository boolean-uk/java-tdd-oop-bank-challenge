package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BankBranch {
    private Map<Integer, BankAccount> allAccounts = new HashMap<>();

    public int createAccount(boolean isCurrentAccount){
        int newAccountNumber = new Random().nextInt(1000,10000);
        BankAccount newAccount;
        if(isCurrentAccount){
            newAccount = new CurrentAccount();
        } else {
            newAccount = new SavingsAccount();
        }
        allAccounts.put(newAccountNumber, newAccount);
        return newAccountNumber;
    }

    public String getBankStatement(int accountNumber){
        return allAccounts.get(accountNumber).generateBankStatement();
    }

    public void depositMoney(int accountNumber, double amount){
        allAccounts.get(accountNumber).depositMoney(amount);
    }

    public void withdrawMoney(int accountNumber, double amount){
        allAccounts.get(accountNumber).withdrawMoney(amount);
    }

    public void requestOverdraft(int accountNumber, double amount) {
        allAccounts.get(accountNumber).requestOverdraft(amount);
    }

    public BankAccount getAccount(int accountNumber){
        return allAccounts.get(accountNumber);
    }
}
