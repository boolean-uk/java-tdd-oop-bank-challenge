package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserTest {
    @Test
    public void testCreateUser()
    {
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);

        Assertions.assertEquals("Large Nimpson", user.getUserName());

        LocalDate birthday2 = LocalDate.of(2019, 9, 29);
        User dog = new User("Fido", birthday2);

        Assertions.assertEquals("Fido", dog.getUserName());
    }

    @Test
    public void testCreateCurrentAccount()
    {
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createCurrentAccount("Groceries");

        Assertions.assertEquals(0,user.getAccount("cu-78105109112115111110-1").getBalance());
        Assertions.assertEquals("Groceries",user.getAccount("cu-78105109112115111110-1").getAccountName());
    }

    @Test
    public void testCreateSavingsAccount()
    {
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createSavingsAccount("Lizzie's college fund");

        Assertions.assertEquals(0,user.getAccount("sa-78105109112115111110-1").getBalance());
        Assertions.assertEquals("Lizzie's college fund",user.getAccount("sa-78105109112115111110-1").getAccountName());
    }

    @Test
    public void testGenerateTransactionStatement()
    {
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createCurrentAccount("Groceries");
        user.makeDeposit("cu-78105109112115111110-1", 100000);
        user.makeWithdrawal("cu-78105109112115111110-1", 5000);

        String expectedString = """
                date       || credit || debit || balance
                2024-01-25 || 1000.0 ||       ||  1000.0
                2024-01-25 ||        ||  50.0 ||   950.0""";
        Assertions.assertEquals(expectedString, user.generateTransactionHistory("cu-78105109112115111110-1"));
    }

    @Test
    public void testDeposit()
    {
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createCurrentAccount("Groceries");

        user.makeDeposit("cu-78105109112115111110-1", 1000);
        Assertions.assertEquals(1000, user.getBalance("cu-78105109112115111110-1"));
        user.makeDeposit("cu-78105109112115111110-1", 300);
        Assertions.assertEquals(1300, user.getBalance("cu-78105109112115111110-1"));
        user.makeDeposit("cu-78105109112115111110-1", -300);
        Assertions.assertEquals(1300, user.getBalance("cu-78105109112115111110-1"));
    }

    @Test
    public void testWithdrawal()
    {
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createCurrentAccount("Groceries");

        user.makeDeposit("cu-78105109112115111110-1", 1000);
        Assertions.assertEquals(1000, user.getBalance("cu-78105109112115111110-1"));
        user.makeWithdrawal("cu-78105109112115111110-1", 300);
        Assertions.assertEquals(700, user.getBalance("cu-78105109112115111110-1"));
        user.makeWithdrawal("cu-78105109112115111110-1", -300);
        Assertions.assertEquals(700, user.getBalance("cu-78105109112115111110-1"));
    }
}