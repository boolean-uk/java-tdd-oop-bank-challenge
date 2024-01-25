package com.booleanuk.core;

public class SavingsAccount extends Account {
    public SavingsAccount(Customer customer, String branch) {
        super(customer, branch);
        this.type = "Savings account";
        customer.addAccount(this.type,this);
    }

}
