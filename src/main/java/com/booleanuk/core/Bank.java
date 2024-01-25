package com.booleanuk.core;

import com.booleanuk.core.enums.Branch;

import java.util.ArrayList;

public class Bank {
    private final AccountHandler accountHandler;

    public Bank(AccountHandler accountHandler){
       this.accountHandler = accountHandler;
    }
    public boolean createSavingsAccount(String accountHolder, Branch branch) {
        return accountHandler.createSavingsAccount(accountHolder, branch);
    }
    public boolean createCurrentAccount(String accountHolder, Branch branch){
        return accountHandler.createCurrentAccount(accountHolder, branch);
    }
    public boolean depositToAccount(int accountNumber, double amount){
        return accountHandler.depositToAccount(accountNumber, amount);
    }
    public boolean withdrawFromAccount(int accountNumber, double amount){
        return accountHandler.withdrawFromAccount(accountNumber, amount);
    }
    public ArrayList<Account> getAccounts(){
        return accountHandler.getAccounts();
    }

    public ArrayList<String> getAccountsInBranch(Branch branch){
       return accountHandler.getAccountsInBranch(branch);
    }
    public String getBankStatementsFromAccount(int accountNumber){
        return accountHandler.getBankStatementsFromAccount(accountNumber);
    }
    public boolean requestOverdraft(int accountNumber){
        return accountHandler.requestOverdraft(accountNumber);
    }
    public ArrayList<String> getRequestedOverdrafts(){
        return accountHandler.getRequestedOverdrafts();
    }
    public void approveOverDraft(int accountNumber){
        accountHandler.approveOverDraft(accountNumber);
    }

}
