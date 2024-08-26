package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    private final ArrayList<Account> accounts;

    public enum AccountType {
        SAVINGS,
        CURRENT
    }

    public Customer(){
        this.accounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }

    public void createAccount(AccountType type, Branch branch){
        if (type == AccountType.CURRENT) {
            accounts.add(new CurrentAccount(branch));
        } else {
            accounts.add(new SavingsAccount(branch));
        }
    }
}
