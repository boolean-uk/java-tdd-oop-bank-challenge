package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount("Test");
        bankAccount.deposit(1000);
        assertEquals(1000.0, bankAccount.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount bankAccount = new BankAccount("Test");
        bankAccount.deposit(1000);
        bankAccount.withdraw(500);
        assertEquals(500.0, bankAccount.getBalance());
    }

    @Test
    public void testGenerateStatement() {
        BankAccount bankAccount = new BankAccount("Test");
        bankAccount.deposit(1000);
        bankAccount.withdraw(500);
        String expectedStatement = "date       || credit  || debit  || balance\n" +
                "25/01/2024 || 1000.00 ||  || 1000.00\n" +
                "25/01/2024 ||  || 500.00 || 500.00\n";
        assertEquals(expectedStatement, bankAccount.generateStatement());
    }
}

