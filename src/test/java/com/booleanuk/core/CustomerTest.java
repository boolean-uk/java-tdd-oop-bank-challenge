package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    @Test
    public void testCreateAndGetSavingsAccount() {
        Customer customer = new Customer("Gustav Svennas");
        Account savingsOne = new SavingsAccount("savings1", 5400, 6900758, 0.00);

        List<Account> expected = new ArrayList<>();
        expected.add(savingsOne);

        customer.addAccount(savingsOne);
        Assertions.assertEquals(expected, customer.getAccounts());
    }

    @Test
    public void testCreateAndGetCurrentAccount() {
        Customer customer = new Customer("Gustav Svennas");
        Account currentOne = new CurrentAccount("current1", 5400, 6900800, 500.00);

        List<Account> expected = new ArrayList<>();
        expected.add(currentOne);

        customer.addAccount(currentOne);
        Assertions.assertEquals(expected, customer.getAccounts());
    }

    @Test
    public void testDepositToAccount() {
        Customer customer = new Customer("Gustav Svennas");
        Account savingsOne = new SavingsAccount("savings1", 5400, 6900758, 0.00);
        customer.addAccount(savingsOne);

        Assertions.assertTrue(customer.depositFounds(500, savingsOne));
        Assertions.assertTrue(customer.depositFounds(64.37, savingsOne));

        Assertions.assertEquals(564.37, customer.showCurrentBalance(savingsOne));
    }

    @Test
    public void testWithdrawFromAccountWithEnoughMoney() {
        Customer customer = new Customer("Gustav Svennas");
        Account savingsOne = new SavingsAccount("savings1", 5400, 6900758, 0.00);
        customer.addAccount(savingsOne);

        Assertions.assertTrue(customer.depositFounds(500, savingsOne));
        Assertions.assertTrue(customer.withdrawFounds(300, savingsOne));
        Assertions.assertEquals(200, customer.showCurrentBalance(savingsOne));

        Account currentsOne = new CurrentAccount("current1", 5400, 6900800, 0.00);
        customer.addAccount(currentsOne);

        Assertions.assertTrue(customer.depositFounds(200, currentsOne));
        Assertions.assertTrue(customer.withdrawFounds(300, currentsOne));
        Assertions.assertEquals(-100, customer.showCurrentBalance(currentsOne));
    }

    @Test
    public void testWithdrawFromAccountsWithNotEnoughMoney() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput = "Can't withdraw that much money from that account!\n";

        Customer customer = new Customer("Gustav Svennas");
        Account savingsOne = new SavingsAccount("savings1", 5400, 6900758, 0.00);
        customer.addAccount(savingsOne);

        Assertions.assertTrue(customer.depositFounds(200, savingsOne));
        Assertions.assertFalse(customer.withdrawFounds(300, savingsOne));
        Assertions.assertEquals(expectedOutput, outContent.toString());
        Assertions.assertEquals(200, customer.showCurrentBalance(savingsOne));

        final ByteArrayOutputStream outContentTwo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentTwo));
        Account currentsOne = new CurrentAccount("current1", 5400, 6900800, 0.00);
        customer.addAccount(currentsOne);

        Assertions.assertTrue(customer.depositFounds(200, currentsOne));
        Assertions.assertFalse(customer.withdrawFounds(400, currentsOne));
        Assertions.assertEquals(expectedOutput, outContentTwo.toString());
        Assertions.assertEquals(200, customer.showCurrentBalance(currentsOne));
    }

    @Test
    public void testGetShortBankStatement() {

    }
}
