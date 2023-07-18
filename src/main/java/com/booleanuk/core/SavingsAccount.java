package com.booleanuk.core;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    SavingsAccount(BigDecimal amount, Customer customer) {
        super(amount, customer);
    }
    SavingsAccount(Customer customer){
        super(customer);
    }

    SavingsAccount(Customer customer, Branch branch){
        super(customer, branch);
    }

    @Override
    public void withdraw(BigDecimal amount) throws IllegalAccessException {
        throw new IllegalAccessException("You can't withdraw from a savings account");
    }
}
