package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testCreateAccountInstance() {
        Account account = new Account();
        Assertions.assertNotNull(account);
        Assertions.assertNotNull(account.getAccountNumber());
    }

    @Test
    public void testGetBalance() {
        Account account = new Account();
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void testSetBalance() {
        Account account = new Account();
        account.setBalance(100.0);
        Assertions.assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testGetTransactions() {
        Account account = new Account();
        Assertions.assertEquals(0, account.getTransactions().size());
    }

    @Test
    public void testAddTransaction() {
        double amountToDeposit = 100.00;
        Account account = new Account();
        account.addTransaction( new Transaction(amountToDeposit, account.getBalance() + amountToDeposit));
        Assertions.assertEquals(1, account.getTransactions().size());

        account.addTransaction( new Transaction(amountToDeposit, account.getBalance() - amountToDeposit));
        Assertions.assertEquals(2, account.getTransactions().size());
    }

}
