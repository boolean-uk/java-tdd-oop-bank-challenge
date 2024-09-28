package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ManagerTest {
    Customer customer;
    Manager manager;

    @BeforeEach
    void setUp() {
        customer = new Customer("customer");
        manager = new Manager("manager");
        customer.createCurrent(123);
        customer.createSavings(321);
    }

    @Test
    void shouldCheckIfOverdraftIsPossible() {
        manager.overdraftRequest(customer);
        Assertions.assertEquals(false, customer.isOverCheck());
        customer.depositFunds(123, BigDecimal.valueOf(500.00));
        customer.withdrawFunds(123, BigDecimal.valueOf(100.00));
        customer.depositFunds(123, BigDecimal.valueOf(250.00));
        customer.depositFunds(123, BigDecimal.valueOf(500.00));
        customer.withdrawFunds(123, BigDecimal.valueOf(100.00));
        manager.overdraftRequest(customer);
        Assertions.assertEquals(false, customer.isOverCheck());
        customer.depositFunds(321, BigDecimal.valueOf(250.00));
        manager.overdraftRequest(customer);
        Assertions.assertEquals(true, customer.isOverCheck());
    }
}
