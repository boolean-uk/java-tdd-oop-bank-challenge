package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void testCreatingCurrentAccountFromBank(){
        Bank bank = new Bank();
        Assertions.assertTrue(bank.createCurrentAccount("John"));
    }
    @Test
    public void testCreatingSavingsAccountFromBank(){
        Bank bank = new Bank();
        Assertions.assertTrue(bank.createSavingsAccount("John"));
    }
}
