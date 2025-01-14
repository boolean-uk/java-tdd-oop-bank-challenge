package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    @Test
    public void depositToAccount() {
        CurrentAccount currentAccount = new CurrentAccount(500);

        currentAccount.deposit(currentAccount,200);

        Assertions.assertEquals(700, currentAccount.getBalance());

    }

    @Test
    public void withdrawToAccount() {
        CurrentAccount currentAccount = new CurrentAccount(500);

        currentAccount.deposit(currentAccount,200);

        Assertions.assertEquals(300, currentAccount.getBalance());

    }
}
