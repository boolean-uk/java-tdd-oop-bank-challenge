package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    String name;
    ArrayList<Account> accounts;

    public Customer(String name){
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account){
        accounts.add(account);
    }
    public void removeAccount(Account account){
        if (accounts.contains(account)){
            System.out.println("removing account");
            accounts.remove(account);
        }
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }


    public String getName(){
        return this.name;
    }
    // Override equals and hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return name.equals(customer.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
