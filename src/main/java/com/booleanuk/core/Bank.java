package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    //private HashMap<Customer, ArrayList<Account>> customers;
    private ArrayList<Customer> customers;
    private int accountID;
    private int customerID;
    private String branch;

    public Bank(String branch){
        //this.customers = new HashMap<>();
        this.customers = new ArrayList<>();
        this.accountID = 0;
        this.branch = branch;

    }

    public boolean newCustomer(Customer customer){

        if(customerExists(customer)){
            System.out.println("Customer already exists");
            return false;
        }
        customers.add(customer);
        return true;
    }

    public boolean customerExists(Customer customer){
        return customers.contains(customer);
    }

    public boolean newAccount(Customer customer, String accountType){

        if (customerExists(customer)){
            if(accountType.equals("Saving")){
                Account newAccount = new SavingsAccount(branch, accountID);
                System.out.println("Created new saving account");
                customer.addAccount(newAccount);
                accountID += 1;
                return true;
            }else if(accountType.equals("Current")){
                Account newAccount = new CurrentAccount(branch, accountID);
                System.out.println("created new current account for user: " + customer.getName());
                customer.addAccount(newAccount);
                accountID += 1;
                return true;
            }
        }

        return false;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public int getUniqueID() {
        return accountID;
    }

    public void setUniqueID(int uniqueID) {
        this.accountID = uniqueID;
    }
}
