package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CoreTest {

    private Bank bank;
    @BeforeEach
    public void init() {
        Bank bank = new Bank();
    }

    @Test
    public void createNewAccountOnNonExistingCustomerTest() {
        Customer customer = new Customer(123, "Tom");
        Account newAccount = bank.createAccount(customer, "Saving");
        Assertions.assertEquals(newAccount, customer.getAccounts().get(0));
    }

    @Test
    public void depositAmountToSavingsAccountTest() {
        Customer customer = new Customer(123, "Tom");
        bank.getCustomerList().add(customer);
        Account customerAccount = new SavingsAccount();
        customer.getAccounts().add(customerAccount);
        double depositBalance = customer.deposit(customerAccount, 100);
        Assertions.assertEquals(customerAccount.getBalance(), depositBalance);
    }

    @Test
    public void withdrawAmountFromSavingsAccountTest() {
        Customer customer = new Customer(123, "Tom");
        bank.getCustomerList().add(customer);
        Account customerAccount = new SavingsAccount();
        customer.getAccounts().add(customerAccount);
        customer.deposit(customerAccount, 100);
        double withdrawBalance = customer.withdraw(customerAccount, 90);
        Assertions.assertEquals(customerAccount.getBalance(), withdrawBalance);
    }

    @Test
    public void depositGeneratesATransactionTest() {
        Customer customer = new Customer(123, "Tom");
        bank.getCustomerList().add(customer);
        Account customerAccount = new SavingsAccount();
        customer.getAccounts().add(customerAccount);
        customer.deposit(customerAccount, 100);
        String transactionToString = customerAccount.transactionListToString();
        Assertions.assertTrue(transactionToString.contains("100"));
    }
}
