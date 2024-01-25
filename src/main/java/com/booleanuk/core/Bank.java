package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
    ArrayList<Customer> customers;
    public Bank(Customer customers) {
        this.customers = new ArrayList<>();
        this.customers.add(customers);
    }

    public void createAccount(){
        Account account = new Account("SavingsAccount", 100.0);

    }

}
