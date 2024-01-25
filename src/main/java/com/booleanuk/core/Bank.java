package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customerList;
    private ArrayList<Account> accountList;

    public Bank() {
        this.customerList = new ArrayList<Customer>();
        this.accountList = new ArrayList<Account>();
    }

    public Account createAccount(Customer customer, String type) {
        return new SavingsAccount();
    }

    private Customer findOrCreateCustomer(Customer customer) {
        return new Customer(123456, "Thomas");
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }
}
