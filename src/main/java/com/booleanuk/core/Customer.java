package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Account> accounts;

    public Customer(ArrayList<Account> accounts){
        this.accounts = accounts;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public String openCurrentAccount(String accountName){
        accounts.add(new CurrentAccount(accountName));
        return "Opened a new current account: '" + accountName + "'.";
    }

    public String openSavingsAccount(String accountName){
        accounts.add(new SavingsAccount(accountName));
        return "Opened a new savings account: '" + accountName + "'.";
    }

    public Account getAccount(String accountName){
        for (Account account : this.accounts){
            if (account.getName().equals(accountName)){
                return account;
            }
        }
        return null;
    }

}
