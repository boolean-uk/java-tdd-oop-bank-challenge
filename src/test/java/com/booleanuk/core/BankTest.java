package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void testCreatingAccountFromBank(){
        Bank bank = new Bank();
        Assertions.assertTrue(bank.createAccount(new SavingsAccount()));
    }
}
