package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Account> accounts;

    Customer(String name){
        this.name = name;
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(String type){
        type = type.toLowerCase();
        if(type.equals("current")){
            Current current = new Current();
            accounts.add(current);
        }
        else if(type.equals("savings")){
            Savings savings = new Savings();
            accounts.add(savings);
        }
        else{
            System.out.println("Error: No such account type.");
        }
    }
}
