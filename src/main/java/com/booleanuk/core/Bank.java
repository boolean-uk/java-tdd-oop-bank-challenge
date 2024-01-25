package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private int id;
    public Bank(){
        this.accounts = new ArrayList<>();
        id = 0;
    }
    public boolean createSavingsAccount(String accountHolder){
        this.accounts.add(new SavingsAccount(id++, accountHolder));
        return true;
    }
    public boolean createCurrentAccount(String accountHolder){
        this.accounts.add(new CurrentAccount(id++, accountHolder));
        return true;
    }
    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }
}
