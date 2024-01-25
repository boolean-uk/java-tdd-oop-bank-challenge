package com.booleanuk.extensions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void checkOverdraftStatus() {
        Bank bank = new Bank();

        bank.openCurrentAccount();

        Account account = bank.getAccounts().get(0);

        Assertions.assertFalse(account.getOverdraftStatus());

        account.requestOverdraft();

        bank.acceptOverdraftRequest(account);

        Assertions.assertTrue(account.getOverdraftStatus());
    }

    @Test
    public void checkingIfBalanceCanBeBelowZero() {
        Bank bank = new Bank();

        bank.openCurrentAccount();

        Account account = bank.getAccounts().get(0);

        Assertions.assertEquals("Invalid withdrawal amount or insufficient funds", account.withdraw(250));

        account.requestOverdraft();

        bank.acceptOverdraftRequest(account);

        Assertions.assertEquals("Successfully withdrawn amount", account.withdraw(250));

        Assertions.assertEquals(-250, account.getBalance());
    }
}
