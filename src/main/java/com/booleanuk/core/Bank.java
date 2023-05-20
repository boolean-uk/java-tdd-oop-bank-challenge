package com.booleanuk.core;

import java.util.*;

public class Bank {



    public static void main(String[] args){

    }
    public enum AccountType {
        CURRENT,
        SAVINGS
    }

    private Map<Integer, Account> accounts;

    public Bank(){
        this.accounts = new HashMap<>();
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public int createAccount(String branch, AccountType accountType, double initialBalance) {
        Account newAccount = AccountType.CURRENT.equals(accountType) ?
                new CurrentAccount(branch, initialBalance) :
                new SavingsAccount(branch, initialBalance);
        accounts.put(newAccount.getId(), newAccount);

        return newAccount.getId();
    }

    public BankStatement generateStatement(int accountId){
        if(!accounts.containsKey(accountId)) return null;
        return new BankStatement(accounts.get(accountId));
    }

}
