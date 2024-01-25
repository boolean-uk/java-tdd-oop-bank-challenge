package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    @Test
    public void checkBalanceAfterDepositAndWithdrawal() {
        Bank bank = new Bank();

        bank.openCurrentAccount();

        Account account = bank.getAccounts().get(0);

        bank.depositToAccount(account, 1000);

        Assertions.assertEquals(1000, account.getBalance());

        bank.withdrawFromAccount(account, 500);

        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void checkingForInvalidWithdrawal() {
        Bank bank = new Bank();

        bank.openCurrentAccount();

        Account account = bank.getAccounts().get(0);

        Assertions.assertEquals("Invalid withdrawal amount or insufficient funds", account.withdraw(10));
    }
}
