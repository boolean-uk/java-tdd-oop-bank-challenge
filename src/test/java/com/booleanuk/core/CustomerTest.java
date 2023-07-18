package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {


    @Test
    public void shouldCreateCustomerWithfullNameUSER() {
        NormalAccount normalAccount = new NormalAccount(123123);
        SavingsAccount savingsAccount = new SavingsAccount(321321);
        Customer customer = new Customer("USER", normalAccount, savingsAccount);
        Assertions.assertEquals("USER", customer.getFullName());
    }

    @Test
    public void shouldCreateCustomerWithNewAccountsProvided() {
        NormalAccount normalAccount = new NormalAccount(123123);
        SavingsAccount savingsAccount = new SavingsAccount(321321);
        Customer customer = new Customer("USER", normalAccount, savingsAccount);
        Assertions.assertEquals("USER", customer.getFullName());
        Assertions.assertEquals(normalAccount, customer.getNormalAccount());
        Assertions.assertEquals(savingsAccount, customer.getSavingsAccount());
    }

}
