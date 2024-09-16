package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BankTest {

    @Test
    public void testCreateSavingsAccountWorks() {
        Bank bank = new Bank();
        bank.createAccount("SA12345", 1000.00, "SavingsAccount");

        assertEquals("SavingsAccount", bank.getAccountType("SA12345"));
        Assertions.assertTrue(bank.createAccount("SA234567", 1000.0, "SavingsAccount"));
        Assertions.assertEquals("SavingsAccount", bank.getAccountType("SA234567"));
    }

    @Test
    public void testCreateCurrentAccountWorks() {
        Bank bank = new Bank();
        bank.createAccount("CA12345", 1000.00, "CurrentAccount");

        assertEquals("CurrentAccount", bank.getAccountType("CA12345"));
        Assertions.assertTrue(bank.createAccount("CA234567", 1000.0, "CurrentAccount"));
        Assertions.assertEquals("CurrentAccount", bank.getAccountType("CA234567"));
    }

    @Test
    public void testCreateCurrentAccountFailsOnAccountType() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.createAccount("CA12345", 1000.0, "Account"));
        assertNull(bank.getAccountType("CA12345"));
    }

    @Test
    public void testCreateSavingsAccountFailsOnAccountType() {
        Bank bank = new Bank();

        Assertions.assertFalse(bank.createAccount("SA12345", 1000.0, "Account"));
        assertNull(bank.getAccountType("SA12345"));
    }
    @Test
    public void testCreateCurrentAccountFailsItAlreadyExists() {
        Bank bank = new Bank();
        bank.createAccount("CA12345", 1000.00, "CurrentAccount");

        assertEquals("CurrentAccount", bank.getAccountType("CA12345"));
        Assertions.assertFalse(bank.createAccount("CA12345", 1000.00, "CurrentAccount"));
    }

    @Test
    public void testCreateSavingsAccountFailsItAlreadyExists() {
        Bank bank = new Bank();
        bank.createAccount("SA12345", 1000.00, "SavingsAccount");

        assertEquals("SavingsAccount", bank.getAccountType("SA12345"));
        Assertions.assertFalse(bank.createAccount("SA12345", 1000.0, "SavingsAccount"));
    }
}

