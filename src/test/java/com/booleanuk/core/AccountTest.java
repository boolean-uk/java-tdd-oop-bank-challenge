package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountTest {

    private static Customer customer;

    @BeforeAll
    public static void setup() {
        customer = new Customer("John", "Doe", LocalDate.parse("1990-01-01"));
    }

    @Test
    public void shouldOpenCurrentAccount() {
        Account current = new CurrentAccount(new BigDecimal("1000"), customer);
        Assertions.assertEquals(new BigDecimal("1000"),current.getBalance());

    }

}
