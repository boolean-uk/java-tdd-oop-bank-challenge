package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    @Test
    public void testCreateAndGetSavingsAccount() {
        Customer customer = new Customer("Gustav Svennas");
        Account savingsOne = new SavingsAccount("savings1", 5400, 6900758, 0.00);

        List<Account> expected = new ArrayList<>();
        expected.add(savingsOne);

        customer.addAccount(savingsOne);
        Assertions.assertEquals(expected, customer.getAccounts());
    }

    @Test
    public void testCreateAndGetCurrentAccount() {
        Customer customer = new Customer("Gustav Svennas");
        Account currentOne = new SavingsAccount("current1", 5400, 6900800, 500.00);

        List<Account> expected = new ArrayList<>();
        expected.add(currentOne);

        customer.addAccount(currentOne);
        Assertions.assertEquals(expected, customer.getAccounts());
    }
}
