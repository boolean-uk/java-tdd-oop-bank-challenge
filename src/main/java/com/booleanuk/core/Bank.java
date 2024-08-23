package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    private HashMap<Customer, Account> customers;

    public Bank(){
        this.customers = new HashMap<>();


    }

    public boolean newCustomer(String name){
        Customer tempCustomer =new Customer(name);

        if(customers.containsKey(tempCustomer)){
            System.out.println("Customer already exists");
            return false;
        }
        customers.put(tempCustomer, new Account());
        return true;
    }

    public boolean newAccount
}
