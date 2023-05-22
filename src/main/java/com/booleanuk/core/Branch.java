package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Branch {

    private String name;
    private Map<String, Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public String createCustomer(){

    }
}
