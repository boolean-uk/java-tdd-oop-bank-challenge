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

        Assertions.assertTrue(customer.addAccount(currentAccount));
        Assertions.assertTrue(customer.addAccount(savingsAccount));

        Assertions.assertEquals(new ArrayList<>(Arrays.asList(currentAccount, savingsAccount)),customer.getAccounts());


    }
}
