package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean addCustomer(Customer customer) {
        if (customers.contains(customer)){
            return false;
        }
        customers.add(customer);
        return true;
    }
}
