package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BranchTest {

    @Test
    public void testAccountsAreAssignedToBranches () {
        Bank bank = new Bank();
        bank.addCustomer(1);
        Customer customer = bank.getCustomers().get(0);
        Assertions.assertTrue(customer.createCurrentAccount(400));

        bank.addCustomer(20);
        Customer customer20 = bank.getCustomers().get(1);
        Assertions.assertTrue(customer20.createCurrentAccount(9990));

        System.out.println(customer.getCurrentAccount().getBranch());
        System.out.println(customer20.getCurrentAccount().getBranch());
    }
}
