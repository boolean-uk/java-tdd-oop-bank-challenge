package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AccountTest {
    @Test
    public void testCreateUser()
    {
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);

        Assertions.assertEquals("Large Nimpson", user.getName());

        LocalDate birthday2 = LocalDate.of(2019, 9, 29);
        User dog = new User("Fido", birthday2);

        Assertions.assertEquals("Fido", user.getName());
    }

    @Test
    public void testCreateCurrentAccount()
    {
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createCurrentAccount("Groceries");

        Assertions.assertEquals(0,user.getAccount(0).getBalance());
        Assertions.assertEquals("Groceries",user.getAccount(1).getName());
    }

    @Test
    public void testCreateSavingsAccount()
    {
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createSavingsAccount("Lizzie's college fund");

        Assertions.assertEquals(0,user.getAccount(0).getBalance());
        Assertions.assertEquals("Lizzie's college fund",user.getAccount(1).getName());
    }

    @Test
    public void testGenerateTransactionStatement()
    {
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createCurrentAccount("Groceries");
        user.makeDeposit(0, 100000);
        user.makeWithdrawal(0, 5000);

        String expectedString = """
                date       || credit  || debit || balance
                25-01-2024 || 1000.00 ||       || 1000.00
                25-01-2024 ||         || 50.00 ||  950.00
                """;
        Assertions.assertEquals(expectedString, user.generateTransactionHistory(0));
    }

    @Test
    public void testDeposit()
    {
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createCurrentAccount("Groceries");

        user.makeDeposit(0, 1000);
        Assertions.assertEquals(1000, user.getBalance(0));
        user.makeDeposit(0, 300);
        Assertions.assertEquals(1300, user.getBalance(0));
        user.makeDeposit(0, -300);
        Assertions.assertEquals(1300, user.getBalance(0));
    }

    @Test
    public void testWithdrawal()
    {
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createCurrentAccount("Groceries");

        user.makeDeposit(0, 1000);
        Assertions.assertEquals(1000, user.getBalance(0));
        user.makeWithdrawal(0, 300);
        Assertions.assertEquals(700, user.getBalance(0));
        user.makeWithdrawal(0, -300);
        Assertions.assertEquals(700, user.getBalance(0));
    }
}
