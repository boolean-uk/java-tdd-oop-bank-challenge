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

    public SavingsAccount getSavingsAccount(int uniqueID){
        for(Account a: accounts){
            if (a.getUniqueID() == uniqueID) {
                return ((SavingsAccount) a);
            }
        }
        return null;
    }
    public CurrentAccount getCurrentAccount(){
        for (Account a: accounts){
            if(a instanceof CurrentAccount){
                return ((CurrentAccount) a);
            }
        }
        return null;
    }




    public String getName(){
        return this.name;
    }
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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
