package com.booleanuk.core;

public class SavingsAccount extends Account {
    public SavingsAccount(Customer customer) {
        super(customer);
        this.type = "Savings account";
        customer.addAccount(this.type,this);
    }

}
