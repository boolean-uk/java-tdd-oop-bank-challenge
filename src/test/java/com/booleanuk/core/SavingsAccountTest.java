package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingsAccountTest {

    @Test
    public void testAccrueInterest() {
        SavingsAccount savingsAccount = new SavingsAccount(0.05);
        savingsAccount.deposit(1000);
        savingsAccount.accrueInterest();
        assertEquals(1050.0, savingsAccount.getBalance());
    }

    @Test
    public void testCheckInterestRate() {
        SavingsAccount savingsAccount = new SavingsAccount(0.05);
        assertEquals(0.05, savingsAccount.checkInterestRate());
    }
}

