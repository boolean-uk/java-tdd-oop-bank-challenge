package com.booleanuk.core;

import java.util.*;

public class Bank {



    public static void main(String[] args){

    }
    public enum AccountType {
        CURRENT,
        SAVINGS
    }

    public enum OverdraftStatus {
        PENDING,
        ACCEPTED,
        REJECTED
    }

    private Map<Integer, Account> accounts;
    private Map<Integer, OverdraftRequest> overdraftRequests;

    public Bank(){
        this.accounts = new HashMap<>();
        this.overdraftRequests = new HashMap<>();
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public Map<Integer, OverdraftRequest> getOverdraftRequests() {
        return overdraftRequests;
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

    public boolean requestOverdraft(int accountId){
        if(!accounts.containsKey(accountId)) return false;
        if(overdraftRequests.containsKey(accountId)) return false;
        if(accounts.get(accountId) instanceof SavingsAccount) return false;

        overdraftRequests.put(accountId, new OverdraftRequest(accountId, OverdraftStatus.PENDING));
        return true;

    }

}
