package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Customer> customers;
    private static ArrayList<Account> accounts;

    public Bank() {
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public boolean addCustomer (int id) {
        for (Customer customer: getCustomers()) {
            if (customer.getId() == id) {
                System.out.println("User with this id already exists");
                return false;
            }
        }
        getCustomers().add(new Customer(id));
        return true;
    }

    public static void addAccount (int customerId, String accountType, int initalDeposit) {
        getAccounts().add(new Account(customerId, accountType, initalDeposit));
    }

}
