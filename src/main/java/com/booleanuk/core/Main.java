package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Customer customer = new Customer("John", "Doe", LocalDate.parse("1990-01-01"));
        Account current = new CurrentAccount(new BigDecimal("1000"), customer);
        current.deposit(new BigDecimal("100"));
        current.deposit(new BigDecimal("100"));
        current.withdraw(new BigDecimal("100"));
        current.printBankStatement();
    }
}
