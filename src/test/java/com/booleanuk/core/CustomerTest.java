package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void CustomerExistTest() {
        Customer customer = new Customer("Abdul", "Khan");
        Assertions.assertEquals("Abdul", customer.getFirstName());
        Assertions.assertEquals("Khan", customer.getLastName());
    }

    @Test
    public void addAccountToCustomerCheckBalance() {
        Customer customer = new Customer("Abdul", "Khan");
        Account account = new CurrentAccount(500);
        customer.addAccount(account);
        Assertions.assertNotNull(customer.getAccounts(), "The account should not be empty!");
        Assertions.assertEquals(500, customer.getAccounts().get(0).getBalance());
    }
}
