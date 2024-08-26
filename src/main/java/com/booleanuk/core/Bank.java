package com.booleanuk.core;

import java.util.ArrayList;

public class Bank {

    private String name;
    private IdGenerator idGenerate;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.idGenerate = new IdGenerator();
        this.customers = new ArrayList<>();
    }

    // newCustomer does not contain any data, just "future proof" incase want to add names, address, etc.
    public boolean addCustomer(Customer newCustomer) {

        // Generating a new customer id
        String newId = "";
        do {
            newId = this.idGenerate.generateId(10);
        } while (this.checkIfIdExists(newId));

        Customer toAdd = new Customer(newId);
        this.customers.add(toAdd);
        return true;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }

    private boolean checkIfIdExists(String id) {
        for (Customer c : this.customers) if (c.getId().equals(id)) return true;
        return false;
    }

}
