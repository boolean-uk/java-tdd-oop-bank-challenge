package com.booleanuk.core;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrentAccountTest {

    @Test
    public void testCurrentAccountCreation() {
        //1. As a customer,
        //So I can safely store and use my money,
        //I want to create a current account.
        String accountNumber = "123456789";
        CurrentAccount currentAccount = new CurrentAccount(accountNumber);

        assertEquals(accountNumber, currentAccount.getAccountNumber());
        assertEquals(0.0, currentAccount.getBalance());
    }

    @Test
    public void testDepositAndWithdraw() {
        //4. As a customer,
        //So I can use my account,
        //I want to deposit and withdraw funds.
        Account account = new CurrentAccount("123456789");

        account.deposit(1000.0);
        account.deposit(2000.0);
        account.withdraw(500.0);

        assertEquals(2500.0, account.getBalance());
    }
}