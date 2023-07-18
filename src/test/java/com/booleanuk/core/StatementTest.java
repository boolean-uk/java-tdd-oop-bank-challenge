package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatementTest {

    @Test
    public void testStatementsAreCreated(){
        Bank bank = new Bank();
        bank.addCustomer(3);
        Customer customer = bank.getCustomers().get(0);

        Assertions.assertTrue(customer.createSavingsAccount(3000));
        Assertions.assertEquals(1, customer.getSavingsAccount().getStatements().size());
        Assertions.assertTrue(customer.deposit("savings", 1200));
        Assertions.assertEquals(2, customer.getSavingsAccount().getStatements().size());
        Assertions.assertTrue(customer.withdraw("savings", 100));

        customer.getSavingsAccount().generateStatements();
    }

}
