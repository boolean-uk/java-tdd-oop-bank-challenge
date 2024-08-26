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

    public String openCurrentAccount(String accountName, Branch branch){
        if (getAccount(accountName) != null){
            return "You already have an account by this name.";
        }

        accounts.add(new CurrentAccount(accountName, branch));
        return "Opened a new current account: '" + accountName + "'.";
    }

    public String openSavingsAccount(String accountName, Branch branch){
        if (getAccount(accountName) != null){
            return "You already have an account by this name.";
        }

        accounts.add(new SavingsAccount(accountName, branch));
        return "Opened a new savings account: '" + accountName + "'.";
    }

    public Account getAccount(String accountName){
        for (Account account : this.accounts){
            if (account.getAccountName().equals(accountName)){
                return account;
            }
        }
        return null;
    }

    public void requestOverdraft(Account account){
        if (account != null){
            account.setOverdraftRequestPending(true);
        }
    }

}
