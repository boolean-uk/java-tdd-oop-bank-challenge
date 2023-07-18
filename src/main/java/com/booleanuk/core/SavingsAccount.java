package com.booleanuk.core;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    SavingsAccount(BigDecimal amount, Customer customer) {
        super(amount, customer);
    }
    SavingsAccount(Customer customer){
        super(customer);
    }
}
