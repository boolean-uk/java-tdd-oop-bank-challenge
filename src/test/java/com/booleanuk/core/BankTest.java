package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class BankTest {
    private HashMap<String, BankAccount> bankAccounts;
    private Bank bank;

    @BeforeEach
    public void setUp() {
        this.bank = new Bank(bankAccounts);
    }

    @Test
    public void testCreateAccount() {
        String branch = "Gothenburg";
        String accountType = "currentAccount";
        int ID = 12345;

        Assertions.assertEquals("Account created successfully!", bank.createAccount(branch, accountType, ID));
    }
}
