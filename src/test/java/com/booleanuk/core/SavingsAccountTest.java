package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    @Test
    public void testDeposit() {
        Account a = new SavingsAccount("1", "0000", "01");
        Assertions.assertEquals(0, a.calculateBalance());
        Assertions.assertEquals("The 1.00 money will be deposited in three (3) days to the account 01.", a.deposit(100));
        Assertions.assertEquals(0, a.calculateBalance());
    }
}