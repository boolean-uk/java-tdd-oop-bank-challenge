package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatementTest {

    @Test
    public void testStatementsAreCreated(){
        Bank bank = new Bank();
        Customer customer = new Customer();
        Assertions.assertTrue(customer.createAccount("savings", 3000));
        Assertions.assertEquals(1, customer.getSavingAccount().getStatements().size());
        Assertions.assertTrue(customer.deposit("savings", 1200));
        Assertions.assertEquals(2, customer.getSavingAccount().getStatements().size());

    }

}
