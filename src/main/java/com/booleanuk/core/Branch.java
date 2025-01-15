package com.booleanuk.core;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<BankAccount> accounts;

    public Branch(String name){
        accounts = new ArrayList<>();
        this.name = name;
    }

    public Boolean addAccount(BankAccount account){
        accounts.add(account);

        return accounts.contains(account);
    }
}
