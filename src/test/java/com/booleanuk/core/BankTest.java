package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @Test
    public void testCreateSavingsAccountWorks() {
        Bank bank = new Bank();
        bank.createAccount("SA12345", 1000.00, "SavingsAccount");

        assertEquals("SavingsAccount", bank.getAccountType("SA12345"));
        bank.createAccount("SA234567", 1000.0, "SavingsAccount");
        Assertions.assertEquals("SavingsAccount", bank.getAccountType("SA234567"));
    }

    @Test
    public void testCreateCurrentAccountWorks() {
        Bank bank = new Bank();
        bank.createAccount("CA12345", 1000.00, "CurrentAccount");

        assertEquals("CurrentAccount", bank.getAccountType("CA12345"));
        bank.createAccount("CA234567", 1000.0, "CurrentAccount");
        Assertions.assertEquals("CurrentAccount", bank.getAccountType("CA234567"));
    }
}
