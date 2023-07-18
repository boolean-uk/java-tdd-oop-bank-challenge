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

    @Test
    public void shouldAddAccountToCustomerAndBank() {
        Bank bank = new Bank();
        int customerId = 1;
        Assertions.assertTrue(bank.addCustomer(customerId));
        int initDeposit = 1000;
        String accountType = "current";
        bank.addAccount(customerId, accountType, initDeposit);
        Customer customer = bank.getCustomers().get(0);
        Assertions.assertEquals(1, customer.getAccounts().size());
        Assertions.assertEquals(initDeposit, customer.getAccounts().get(0).getBalance());
        Assertions.assertEquals(1, bank.getAccounts().size());
    }

}
