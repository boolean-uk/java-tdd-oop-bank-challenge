package com.booleanuk.core;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private ArrayList<Customer> customers;
//    public Customer customer;


    public Bank(){
        this.accounts = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    public boolean addAccount (String accountNumber, int formerDeposit, String accountType) {
        System.out.println("Before for loop");
        for (Account account : getAccounts()) {
            System.out.println("In for loop");
            if (account.getAccountType().equals(accountType) && account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Customer has already a " + accountType + "account.");
                return false;
            }
        }
        getAccounts().add(new Account(accountNumber, formerDeposit, accountType));
        System.out.println("Successfully added new account number " + accountNumber);
        return true;
    }

    public boolean addCustomer (int id) {
        System.out.println("Before for loop");
        for (Customer customer: getCustomers()){
            System.out.println("Inside for loop");
            if (customer.getId() == id) {
                System.out.println("Customer with this " + id + " number already exists.");
                return false;
            }
        }
        getCustomers().add(new Customer(id));
        System.out.println("Successfully added new Customer with id nr " + id + ".");
        return true;
    }

}
