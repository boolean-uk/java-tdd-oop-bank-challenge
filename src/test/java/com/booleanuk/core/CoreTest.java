package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class CoreTest {

    private Bank bank;
    private Scanner scanner;
    @BeforeEach
    public void init() {
        bank = new Bank();
    }

    @Test
    public void createNewAccountOnNonExistingCustomerTest() {
        Customer customer = new Customer(123, "Tom", bank);
        Account newAccount = this.bank.createAccount(customer, "S");
        Assertions.assertEquals(newAccount, customer.getAccounts().get(0));
        Assertions.assertEquals(SavingsAccount.class, newAccount.getClass());
    }

    @Test
    public void createNewAccountOnExistingCustomerTest() {
        Customer customer = new Customer(123, "Tom", bank);
        bank.getCustomerList().add(customer);
        Account newAccount = bank.createAccount(customer, "C");
        Assertions.assertEquals(newAccount, customer.getAccounts().get(0));
        Assertions.assertEquals(CurrentAccount.class, newAccount.getClass());
    }

    @Test
    public void depositAmountToSavingsAccountTest() {
        Customer customer = new Customer(123, "Tom", bank);
        bank.getCustomerList().add(customer);
        Account customerAccount = new SavingsAccount(customer);
        customer.getAccounts().add(customerAccount);
        double depositBalance = customer.deposit(customerAccount, 100);
        Assertions.assertEquals(customerAccount.getBalance(), depositBalance);
    }

    @Test
    public void withdrawAmountFromSavingsAccountTest() {
        Customer customer = new Customer(123, "Tom", bank);
        bank.getCustomerList().add(customer);
        Account customerAccount = new SavingsAccount(customer);
        customer.getAccounts().add(customerAccount);
        customer.deposit(customerAccount, 100);
        double withdrawBalance = customer.withdraw(customerAccount, 90);
        Assertions.assertEquals(customerAccount.getBalance(), withdrawBalance);
    }

    @Test
    public void depositGeneratesATransactionTest() {
        Customer customer = new Customer(123, "Tom", bank);
        bank.getCustomerList().add(customer);
        Account customerAccount = new SavingsAccount(customer);
        customer.getAccounts().add(customerAccount);
        customer.deposit(customerAccount, 100);
        customer.deposit(customerAccount, 200);
        customer.deposit(customerAccount, 400);
        customer.withdraw(customerAccount,300);
        customer.deposit(customerAccount, 400);
        customer.withdraw(customerAccount,300);
        customer.deposit(customerAccount, 100);
        customer.deposit(customerAccount, 200);
        customer.deposit(customerAccount, 99700);
        customer.deposit(customerAccount, 200);
        String transactionToString = customerAccount.transactionListToString();
        Assertions.assertTrue(transactionToString.contains("300"));
        Assertions.assertTrue(transactionToString.contains("200"));
    }
    @Test
    public void testSetOverdraftOnCurrentAccountTest() {
        Customer customer = new Customer(123, "Tom", bank);
        bank.getCustomerList().add(customer);
        CurrentAccount customerAccount = new CurrentAccount(customer);
        customer.getAccounts().add(customerAccount);
        String userInput = "y";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        scanner = new Scanner(inputStream);
        boolean wasOverdrafted = customer.requestOverdraftOnAccount(customerAccount, scanner);
        Assertions.assertTrue(wasOverdrafted);
        Assertions.assertEquals(-500.0, customerAccount.getLowerBalanceLimit());
    }

    @Test
    public void denyOverdraftOnCurrentAccountTest() {
        Customer customer = new Customer(123, "Tom", bank);
        bank.getCustomerList().add(customer);
        CurrentAccount customerAccount = new CurrentAccount(customer);
        customer.getAccounts().add(customerAccount);
        String userInput = "n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        scanner = new Scanner(inputStream);
        boolean wasOverdrafted = customer.requestOverdraftOnAccount(customerAccount, scanner);
        Assertions.assertFalse(wasOverdrafted);
        Assertions.assertEquals(0, customerAccount.getLowerBalanceLimit());
    }

}
