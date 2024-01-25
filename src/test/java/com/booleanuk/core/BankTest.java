package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void checkIfAccountsExist() {
        Bank bank = new Bank();

        bank.openCurrentAccount();

        Assertions.assertEquals(1, bank.getAccounts().size());

        bank.openSavingsAccount();

        Assertions.assertEquals(2, bank.getAccounts().size());
    }
}
