package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentAccountTest {

    @Test
    public void testDeposit() {
        Account a = new CurrentAccount("1", "0000", "01");
        Assertions.assertEquals(0, a.calculateBalance());
        Assertions.assertEquals("The 1.00 money is now deposited to the account 01.", a.deposit(100));
        Assertions.assertEquals(100, a.calculateBalance());
    }

    @Test
    public void testWithdraw() {
        CurrentAccount a = new CurrentAccount("1", "0000", "01");
        a.deposit(10000);
        Assertions.assertEquals(10000, a.calculateBalance());
        Assertions.assertEquals("The 1.00 money is now deposited to the account 01.", a.withdraw(5000));
        Assertions.assertEquals(5000, a.calculateBalance());
    }

}