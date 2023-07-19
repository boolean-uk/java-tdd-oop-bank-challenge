package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {

    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @Test
    void createAccountSuccessfullyTest() {
        bank.createAccount("John", "Smith");
        Assertions.assertEquals("John", bank.getAccounts().get(0).getFirstname());
        Assertions.assertEquals("Smith", bank.getAccounts().get(0).getLastname());
    }

    @Test
    void printStatementShouldSucceedTest() {
        bank.createAccount("John", "Smith");
        Account johnAccount = bank.getAccounts().get(0);
        johnAccount.deposit(1500);
        johnAccount.withdraw(500);
        johnAccount.deposit(200);
        Assertions.assertTrue(bank.printStatement(johnAccount));
    }
}
