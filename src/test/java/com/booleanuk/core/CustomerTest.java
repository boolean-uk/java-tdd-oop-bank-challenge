package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerTest {

    @Test
    public void initCustomer() {
        Customer customer = new Customer();
        Account currentAccount = new CurrentAccount();
        Account savingsAccount = new SavingsAccount();

        Assertions.assertTrue(customer.createAccount(currentAccount));
        Assertions.assertTrue(customer.createAccount(savingsAccount));

        Assertions.assertEquals(new ArrayList<>(Arrays.asList(currentAccount, savingsAccount)),customer.getAccounts());
    }

    @Test
    public void createAndDeleteAccount() {
        Customer customer = new Customer();
        Account savingsAccount = new SavingsAccount();
        Account currentAccount = new CurrentAccount();

        Assertions.assertTrue(customer.createAccount(savingsAccount));
        Assertions.assertTrue(customer.createAccount(currentAccount));

        Assertions.assertEquals(savingsAccount, customer.getAccount(savingsAccount));
        Assertions.assertEquals(currentAccount, customer.getAccount(currentAccount));

        Assertions.assertTrue(customer.getAccounts().contains(savingsAccount));
        Assertions.assertTrue(customer.getAccounts().contains(currentAccount));

        Assertions.assertTrue(customer.deleteAccount(savingsAccount));
        Assertions.assertTrue(customer.deleteAccount(currentAccount));

        Assertions.assertFalse(customer.getAccounts().contains(savingsAccount));
        Assertions.assertFalse(customer.getAccounts().contains(currentAccount));
    }

    @Test
    public void depositAndWithdraw() {

    }

}
