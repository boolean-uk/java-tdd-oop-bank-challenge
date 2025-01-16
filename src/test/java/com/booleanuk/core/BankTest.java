package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BankTest {
    private HashMap<String, BankAccount> bankAccounts;
    private Bank bank;

    @BeforeEach
    public void setUp() {
        this.bankAccounts = new HashMap<>();
        this.bank = new Bank(bankAccounts);
    }

    @Test
    public void testCreateAccount() {
        String branch = "Gothenburg";
        String accountType = "currentAccount";
        int ID = 12345;
        String invalidType = "otherAccount";

        Assertions.assertEquals("currentAccount created successfully!", bank.createAccount(branch, accountType, ID));
        Assertions.assertEquals("Account could not be created, invalid account type", bank.createAccount(branch, invalidType, ID));
    }
}
