package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    @Test
    public void testCreateCustomerInstance() {
        Customer customer = new Customer("Name");
        Assertions.assertNotNull(customer);
    }

    @Test
    public void testRequestCurrentAccount() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        bank.addCustomer(customer);
        Assertions.assertTrue(customer.requestCurrentAccount());
        Assertions.assertEquals(1, customer.getAccounts().size());

        Customer customer2 = new Customer("Name");
        Assertions.assertFalse(customer2.requestCurrentAccount());

        Customer customer3 = new Customer("Name");
        customer3.setBank(new Bank("Name"));
        Assertions.assertFalse(customer3.requestCurrentAccount());
    }

    @Test
    public void testRequestSavingsAccount() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        bank.addCustomer(customer);
        Assertions.assertTrue(customer.requestSavingsAccount());
        Assertions.assertEquals(1, customer.getAccounts().size());

        Customer customer2 = new Customer("Name");
        Assertions.assertFalse(customer2.requestSavingsAccount());

        Customer customer3 = new Customer("Name");
        customer3.setBank(new Bank("Name"));
        Assertions.assertFalse(customer3.requestCurrentAccount());
    }

    @Test
    public void testGetAccounts() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        Assertions.assertEquals(0, customer.getAccounts().size());
    }

    @Test
    public void testSetAccounts() {
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        Account account = new Account();
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        customer.setAccounts(accounts);
        Assertions.assertEquals(1, customer.getAccounts().size());
    }

    @Test
    public void testGetBank() {
        Customer customer = new Customer("Name");
        Assertions.assertNull(customer.getBank());
    }

    @Test
    public void testSetBank() {
        Customer customer = new Customer("Name");
        Bank bank = new Bank("Bank");
        customer.setBank(bank);
        Assertions.assertEquals(bank, customer.getBank());
    }

    @Test
    public void testDepositInCurrentAccount() {
        double amountToDeposit = 100.00;
        Bank bank = new Bank("Bank");
        Customer customer = new Customer("Name");
        bank.addCustomer(customer);
        customer.requestCurrentAccount();
        Account currentAccount = customer.getAccounts().getFirst();
        Assertions.assertTrue(customer.deposit(currentAccount, amountToDeposit));
        Assertions.assertEquals(amountToDeposit, currentAccount.getBalance());

    }

}
