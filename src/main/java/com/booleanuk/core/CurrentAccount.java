package com.booleanuk.core;

import java.math.BigDecimal;

public class CurrentAccount extends Account {
    CurrentAccount(BigDecimal amount, Customer customer) {
        super(amount, customer);
    }
    CurrentAccount(Customer customer) {
        super(customer);
    }
}
