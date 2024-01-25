package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoreTest {

    private Bank bank;
    @BeforeEach
    public void init() {
        bank = new Bank();
    }

    @Test
    public void createNewAccountOnNonExistingCustomerTest() {
        Customer customer = new Customer(123, "Tom");
        Account newAccount = this.bank.createAccount(customer, "Saving");
        Assertions.assertEquals(newAccount, customer.getAccounts().get(0));
    }

    @Test
    public void depositAmountToSavingsAccountTest() {
        Customer customer = new Customer(123, "Tom");
        bank.getCustomerList().add(customer);
        Account customerAccount = new SavingsAccount(customer);
        customer.getAccounts().add(customerAccount);
        double depositBalance = customer.deposit(customerAccount, 100);
        Assertions.assertEquals(customerAccount.getBalance(), depositBalance);
    }

    @Test
    public void withdrawAmountFromSavingsAccountTest() {
        Customer customer = new Customer(123, "Tom");
        bank.getCustomerList().add(customer);
        Account customerAccount = new SavingsAccount(customer);
        customer.getAccounts().add(customerAccount);
        customer.deposit(customerAccount, 100);
        double withdrawBalance = customer.withdraw(customerAccount, 90);
        Assertions.assertEquals(customerAccount.getBalance(), withdrawBalance);
    }

    @Test
    public void depositGeneratesATransactionTest() {
        Customer customer = new Customer(123, "Tom");
        bank.getCustomerList().add(customer);
        Account customerAccount = new SavingsAccount(customer);
        customer.getAccounts().add(customerAccount);
        customer.deposit(customerAccount, 100);
        customer.deposit(customerAccount, 200);
        customer.deposit(customerAccount, 400);
        customer.withdraw(customerAccount,300);
        String transactionToString = customerAccount.transactionListToString();
        Assertions.assertTrue(transactionToString.contains("300"));
        Assertions.assertTrue(transactionToString.contains("200"));
    }
}
