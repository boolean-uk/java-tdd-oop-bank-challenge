package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    @Test
    public void testCurrentAccountConstructor() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account savingsAccount = new SavingsAccount("1", customer, branch);
        Assertions.assertEquals("1", savingsAccount.getAccountId());
        Assertions.assertEquals(customer, savingsAccount.getCustomer());
        Assertions.assertEquals(branch, savingsAccount.getBranch());
        Assertions.assertEquals(0.0, savingsAccount.getBalance());
    }

    @Test
    public void testRequestOverdraft() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account savingsAccount = new SavingsAccount("1", customer, branch);
        Assertions.assertEquals("You can not overdraft a savings account", savingsAccount.requestOverdraft(1));
    }

    @Test
    public void testSetOverdraftLimit() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account savingsAccount = new SavingsAccount("1", customer, branch);
        savingsAccount.setOverdraftLimit(100);
        Assertions.assertEquals(0.0, savingsAccount.getOverdraftLimit());
    }
}