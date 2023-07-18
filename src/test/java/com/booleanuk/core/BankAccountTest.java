package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BankAccountTest {

    Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("customer");
        CurrentAccount accountCurr = new CurrentAccount(123);
        SavingsAccount accountSave = new SavingsAccount(321);
        customer.setSavings(accountSave);
        customer.setCurrent(accountCurr);
    }

    @Test
    void shouldReturnTotalBalance() {
        customer.depositFunds(123, BigDecimal.valueOf(125));
        customer.depositFunds(123, BigDecimal.valueOf(75));
        customer.withdrawFunds(123,BigDecimal.valueOf(90));
        Assertions.assertEquals(BigDecimal.valueOf(110), customer.getCurrent().getBalance());

        customer.depositFunds(321, BigDecimal.valueOf(400));
        customer.depositFunds(321, BigDecimal.valueOf(80));
        customer.withdrawFunds(321,BigDecimal.valueOf(180));
        Assertions.assertEquals(BigDecimal.valueOf(300), customer.getSavings().getBalance());
    }
}
