package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void isBankCreated(){
        Bank bank = new Bank();
        Assertions.assertTrue(bank.getCustomers().isEmpty());
        Assertions.assertTrue(bank.getAccounts().isEmpty());
    }

    @Test
    public void shouldAddCustomerToBank() {
        Bank bank = new Bank();
        int customerId = 123;
        Assertions.assertTrue(bank.addCustomer(customerId));
        Assertions.assertEquals(1, bank.getCustomers().size());
    }
}
