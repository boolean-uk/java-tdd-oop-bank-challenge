package com.booleanuk.extension;

import com.booleanuk.core.Account;
import com.booleanuk.core.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testCreateAccountInstance() {
        com.booleanuk.core.Account account = new com.booleanuk.core.Account();
        Assertions.assertNotNull(account);
        Assertions.assertNotNull(account.getAccountNumber());
    }

    @Test
    public void testGetBalance() {
        com.booleanuk.core.Account account = new com.booleanuk.core.Account();
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void testSetBalance() {
        com.booleanuk.core.Account account = new com.booleanuk.core.Account();
        account.setBalance(100.0);
        Assertions.assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testGetTransactions() {
        com.booleanuk.core.Account account = new com.booleanuk.core.Account();
        Assertions.assertEquals(0, account.getTransactions().size());
    }

    @Test
    public void testAddTransaction() {
        double amountToDeposit = 100.00;
        com.booleanuk.core.Account account = new Account();
        account.addTransaction( new com.booleanuk.core.Transaction(amountToDeposit, account.getBalance() + amountToDeposit));
        Assertions.assertEquals(1, account.getTransactions().size());

        account.addTransaction( new Transaction(amountToDeposit, account.getBalance() - amountToDeposit));
        Assertions.assertEquals(2, account.getTransactions().size());
    }

}
