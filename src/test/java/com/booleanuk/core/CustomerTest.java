package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomerTest {
    private Customer customer;
    private final String branchCode = "123";

    @BeforeEach
    public void setUp() {
        customer = new Customer("01234567890",
                "john.doe@gmail.com", "John", "Doe");
    }

    @Test
    public void shouldCreateCurrentAccount() {
        BankAccount account = customer.createAccount(AccountType.CURRENT, branchCode);
        Assertions.assertEquals(List.of(account), customer.getAccounts());
    }

    @Test
    public void shouldCreateSavingsAccount() {
        BankAccount account = customer.createAccount(AccountType.SAVINGS, branchCode);
        Assertions.assertEquals(List.of(account), customer.getAccounts());
    }

    @Test
    public void depositShouldSucceed() {
        BankAccount account = customer.createAccount(AccountType.CURRENT, branchCode);
        customer.deposit(account.getAccountNumber(), 100.0d);
        Assertions.assertEquals(100.0d, account.getBalance());
    }

    @Test
    public void depositShouldFail1() {
        BankAccount account = customer.createAccount(AccountType.CURRENT, branchCode);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> customer.deposit(account.getAccountNumber(), -100.0d));
    }

    @Test
    public void depositShouldFail2() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> customer.deposit("1231231231231", 1.0d));
    }

    @Test
    public void withdrawShouldSucceed() {
        BankAccount account = customer.createAccount(AccountType.CURRENT, branchCode);
        customer.deposit(account.getAccountNumber(), 100.0d);
        customer.withdraw(account.getAccountNumber(), 50.0d);
        Assertions.assertEquals(50.0d, account.getBalance());
    }

    @Test
    public void withdrawShouldFail1() {
        BankAccount account = customer.createAccount(AccountType.CURRENT, branchCode);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> customer.withdraw(account.getAccountNumber(), -100.0d));
    }

    @Test
    public void withdrawShouldFail2() {
        BankAccount account = customer.createAccount(AccountType.CURRENT, branchCode);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> customer.withdraw(account.getAccountNumber(), 100.0d));
    }

    @Test
    public void shouldCreateStatement() {
        BankAccount account = customer.createAccount(AccountType.CURRENT, branchCode);
        customer.deposit(account.getAccountNumber(), 100.0d);
        customer.withdraw(account.getAccountNumber(), 50.0d);
        Assertions.assertEquals(2, customer.getStatements().get(0).getTransactions().size());
    }

    @Test
    public void shouldCreateConcreteStatements() throws InterruptedException {
        BankAccount account = customer.createAccount(AccountType.CURRENT, branchCode);
        customer.deposit(account.getAccountNumber(), 100.0d);
        Thread.sleep(1000);
        customer.withdraw(account.getAccountNumber(), 50.0d);
        String actual = customer.getStatements().get(0).toString();

        String todayDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        String expected = "Statement for account number: " + account.getAccountNumber() + System.lineSeparator() +
                "date       || credit || debit || balance" + System.lineSeparator() +
                todayDate + " ||        || 50.00 || 50.00" + System.lineSeparator() +
                todayDate + " || 100.00 ||       || 100.00" + System.lineSeparator();

        Assertions.assertEquals(expected, actual);
    }
}
