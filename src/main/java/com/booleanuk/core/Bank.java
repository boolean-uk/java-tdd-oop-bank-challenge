package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private ArrayList<Account> overdraftRequests;
    private int id;
    public Bank(){
        this.accounts = new ArrayList<>();
        this.overdraftRequests = new ArrayList<>();
        id = 1;
    }
    public boolean createSavingsAccount(String accountHolder, Branch branch){
        this.accounts.add(new SavingsAccount(id++, accountHolder, branch));
        return true;
    }
    public boolean createCurrentAccount(String accountHolder, Branch branch){
        this.accounts.add(new CurrentAccount(id++, accountHolder, branch));
        return true;
    }
    public boolean depositToAccount(int accountNumber, double amount){
        for(Account account : accounts){
            if(account.getAccountId() == accountNumber){
                return account.deposit(amount);
            }
        }
        return false;
    }
    public boolean withdrawFromAccount(int accountNumber, double amount){
        for(Account account : accounts){
            if(account.getAccountId() == accountNumber){
                return account.withdraw(amount);
            }
        }
        return false;
    }
    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }

    public ArrayList<String> getAccountsInBranch(Branch branch){
        ArrayList<String> temp = new ArrayList<>();
        for(Account account : accounts){
            if(account.getBranch().equals(branch)){
                temp.add(account.toString());
            }
        }
        return temp;
    }
    public String getBankStatementsFromAccount(int accountNumber){
        ArrayList<String> statements = new ArrayList<>();
        for(Account account : accounts){
            if(account.getAccountId() == accountNumber){
                statements.addAll(account.getBankStatements());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : statements){
            sb.append(s).append("\n");
        }
        return sb.toString();
    }
    public boolean requestOverdraft(int accountNumber){
        for(Account account : accounts){
            if(account.getAccountId() == accountNumber && account instanceof CurrentAccount && !account.getOverdraftApproved()){
                overdraftRequests.add(account);
                return true;
            }
        }
        return false;
    }
}
