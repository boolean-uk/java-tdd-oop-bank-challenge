package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void testAccountCurrentAccount(){
        Branch branch = new Branch("Oslo Branch");
        Customer customer = new Customer("Customer1", branch);

        customer.getCurrentAccount().deposit(100);
        Assertions.assertEquals(100, customer.getCurrentAccount().getBalance());

        customer.getCurrentAccount().withdraw(100);
        Assertions.assertEquals(0, customer.getCurrentAccount().getBalance());

        customer.getCurrentAccount().withdraw(100);
        Assertions.assertEquals(0, customer.getCurrentAccount().getBalance());

        customer.getCurrentAccount().setOverDrawAmount(100);
        customer.getCurrentAccount().withdraw(100);
        Assertions.assertEquals(-100, customer.getCurrentAccount().getBalance());
    }
    @Test
    public void testAccountSavingAccount() {
        Branch branch = new Branch("Oslo Branch");
        Customer customer = new Customer("Customer1", branch);

        customer.getSavingsAccount().deposit(100);
        Assertions.assertEquals(100, customer.getSavingsAccount().getBalance());

        customer.getSavingsAccount().withdraw(200);
        Assertions.assertEquals(100, customer.getSavingsAccount().getBalance());

        customer.getSavingsAccount().withdraw(100);
        Assertions.assertEquals(0, customer.getSavingsAccount().getBalance());
    }
}
