package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customerList;
    private ArrayList<Account> accountList;

    public Bank() {
        this.customerList = new ArrayList<>();
        this.accountList = new ArrayList<>();
    }

    public Account createAccount(Customer customer, String type) {
        findOrCreateCustomer(customer);
        Account account = null;
        if(type.equalsIgnoreCase("s")) {
            account = new SavingsAccount(customer);
        } else if(type.equalsIgnoreCase("c")) {
            account = new CurrentAccount(customer);
        }
        customer.getAccounts().add(account);
        this.accountList.add(account);
        return account;
    }

    private void findOrCreateCustomer(Customer customer) {
        if(!customerList.contains(customer)) {
            customerList.add(customer);
        }
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }
}
