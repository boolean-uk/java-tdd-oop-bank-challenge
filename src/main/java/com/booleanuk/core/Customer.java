package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Account> accounts;
    private int customerID;
    private Bank mybank;


    public Customer(String name, int customerID, Bank bank){
        this.name = name;
        this.accounts = new ArrayList<>();
        this.customerID = customerID;
        this.mybank = bank;
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

    public Account getAccount(int uniqueID){
        for(Account a: accounts){
            if (a.getUniqueID() == uniqueID) {
                return (a);
            }
        }
        return null;
    }

    //print out all statements for all accounts for this customer
    public boolean generateCustomerStatement(){
        for (Account a: accounts){
            a.generateAccountStatement();

        }
        return true;
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
