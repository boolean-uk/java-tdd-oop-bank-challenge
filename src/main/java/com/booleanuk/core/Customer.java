package com.booleanuk.core;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer {
    private ArrayList<Account> accounts;

    enum AccountType {
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
