package com.booleanuk.core;

import com.booleanuk.CurrentAccount;
import com.booleanuk.SavingAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private CurrentAccount currentAccount;

    @BeforeEach
    public void setUp() {
        currentAccount = new CurrentAccount();
    }

    @Test
    public void testCreateCurrentAccount() {

        Assertions.assertEquals(0.0, currentAccount.getBalance());
        Assertions.assertEquals(0, currentAccount.getTransactions().size());
    }

    @Test
    public void testCreateSavingAccount() {
        SavingAccount currentAccount = new SavingAccount();

        Assertions.assertEquals(0.0, currentAccount.getBalance());
        Assertions.assertEquals(0, currentAccount.getTransactions().size());
    }

    @Test
    public void testDeposit() {
        currentAccount.deposit(25.30);
        Assertions.assertEquals(25.3, currentAccount.getBalance());
    }

    @Test
    public void testDepositInvalidAmount() {
        Assertions.assertEquals("Please enter a valid number", currentAccount.deposit(-5));
        Assertions.assertEquals(0, currentAccount.getBalance());
    }

    @Test
    public void testWithdraw() {
        currentAccount.deposit(50);
        currentAccount.withdraw(25.5);
        Assertions.assertEquals(24.5, currentAccount.getBalance());
    }

    @Test
    public void testWithdrawInvalidNumber() {
        currentAccount.deposit(50);
        String expected = "Insufficient quantity. This transaction cannot be completed";
        Assertions.assertEquals(expected, currentAccount.withdraw(51.5));
        Assertions.assertEquals(50, currentAccount.getBalance());
    }
}
