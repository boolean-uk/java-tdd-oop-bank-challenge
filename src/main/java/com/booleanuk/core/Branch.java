package com.booleanuk.core;

import java.util.HashMap;

public class Branch {

    private final int branchID;
    private static int counter = 1000;
    private HashMap<Integer, Account> accounts = new HashMap<>();
    private int accountID = 100000;

    public Branch(){
        this.branchID = counter;
        counter += 1;
    }

    public int getBranchID(){
        return this.branchID;
    }

    public HashMap<Integer, Account> getAccounts(){
        return this.accounts;
    }

    public void createCurrentAccount( ){
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.setAccountNumber(branchID, accountID);
        accounts.put(accountID, currentAccount);
        accountID+=1;
    }

    public void createSavingsAccount( ){
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountNumber(branchID, accountID);
        accounts.put(accountID, savingsAccount);
        accountID+=1;
    }

}
