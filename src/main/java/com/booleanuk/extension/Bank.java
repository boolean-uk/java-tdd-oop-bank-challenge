package com.booleanuk.extension;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String name;
    private final List<Customer> customers;
    private final List<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.branches = new ArrayList<>();
        addBranch(new Branch("00", "Address"));
        addBranch(new Branch("01", "Address"));
    }

    public boolean createCurrentAccount(Customer customer, Branch branch){
        if (!customers.contains(customer)) {
            return false;
        }
        List<Account> customerAccounts = customer.getAccounts();
        Account currentAccount = new CurrentAccount();
        currentAccount.setBranch(branch);
        customerAccounts.add(currentAccount);
        customer.setAccounts(customerAccounts);
        return true;
    }

    public boolean createSavingsAccount(Customer customer, Branch branch){
        if (!customers.contains(customer)) {
            return false;
        }
        List<Account> customerAccounts = customer.getAccounts();
        Account savingsAccount = new SavingsAccount();
        savingsAccount.setBranch(branch);
        customerAccounts.add(savingsAccount);
        customer.setAccounts(customerAccounts);
        return true;
    }

    public boolean addCustomer(Customer customer) {
        if (customers.contains(customer)){
            return false;
        }
        customer.setBank(this);
        customers.add(customer);
        return true;
    }

    public boolean addBranch(Branch branch) {
        if (branches.contains(branch)){
            return false;
        }
        branches.add(branch);
        return true;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }
}
