package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class BankTest {

    Bank bank = new Bank();
    Customer customer = new Customer("Bob Bagel", 1234);

    @Test
    public void createCurrentAccountTest() {
        ArrayList<Account> accounts = bank.getAccounts(customer);
        Assertions.assertEquals(null, accounts);
        int bankId = bank.createCurrentAccount(customer);
        Assertions.assertEquals(bankId, bank.getAccounts(customer).get(0).getId());
    }

}
