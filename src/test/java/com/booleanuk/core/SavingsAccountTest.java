package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    @Test
    public void testDeposit() {
        Account a = new SavingsAccount("1", "0000", "01");
        Assertions.assertEquals(0, a.calculateBalance());
        Assertions.assertEquals("The 1.00 money will be deposited in three (3) days to the account 01.", a.deposit(100));
        Assertions.assertEquals(0, a.calculateBalance());
    }

    @Test
    public void testTransfer() {
        Account a = new SavingsAccount("1", "0000", "01");
        Account b = new CurrentAccount("1", "0000", "02");
        Controller.depositables.put("01", a);
        Controller.depositables.put("02", b);
        a.deposit(new Transaction(LocalDateTime.now().minusDays(1), "-1", "01", 10000));
        Assertions.assertEquals(10000, a.calculateBalance());
        Assertions.assertEquals("50.00 money will be transferred from account 01 to account 02 in three (3) days.", a.transfer("02", 5000), "");
        Assertions.assertEquals(10000, a.calculateBalance());
        Assertions.assertEquals(0, b.calculateBalance());
        Assertions.assertEquals(2, a.getTransactions().size());
        Assertions.assertEquals(1, b.getTransactions().size());
        Assertions.assertEquals(a.getTransactions().getLast(), b.getTransactions().getLast());
    }

    @Test
    public void testTransferWithoutMoney() {
        Account a = new SavingsAccount("1", "0000", "01");
        Account b = new CurrentAccount("1", "0000", "02");
        Controller.depositables.put("01", a);
        Controller.depositables.put("02", b);
        Assertions.assertEquals(0, a.calculateBalance());
        Assertions.assertEquals("Not enough balance in 3 days to transfer 50.00 money. Please deposit more money first.", a.transfer("02", 5000), "");
        Assertions.assertEquals(0, b.calculateBalance());
        Assertions.assertEquals(0, a.calculateBalance());
        Assertions.assertEquals(0, a.getTransactions().size());
        Assertions.assertEquals(0, b.getTransactions().size());

    }
}