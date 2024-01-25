package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    public Bank(){
        this.accounts = new ArrayList<>();
    }
    public boolean createAccount(Account account){
        this.accounts.add(account);
        return true;
    }
}
