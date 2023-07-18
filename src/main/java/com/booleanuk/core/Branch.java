package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private final String branchCode;
    private final String country;
    private final String town;
    private final List<Customer> customers = new ArrayList<>();

   public Branch(String branchCode, String country, String town) {
        this.branchCode = branchCode;
        this.country = country;
        this.town = town;
    }

    public void addCustomer(Customer customer){
        if (customers.contains(customer)) {
            System.out.println("Customer is already registered in this branch.");
        } else {
            customers.add(customer);
            System.out.println("Customer registered.");
        }
   }

    public String getBranchCode() {
        return branchCode;
    }
}
