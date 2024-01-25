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
        Account savingsOne = new SavingsAccount("savings1", 5400, 6900758);

        List<Account> expected = new ArrayList<>();
        expected.add(savingsOne);

        customer.addAccount(savingsOne);
        Assertions.assertEquals(expected, customer.getAccounts());
    }

    @Test
    public void testCreateAndGetCurrentAccount() {
        Customer customer = new Customer("Gustav Svennas");
        Account currentOne = new CurrentAccount("current1", 5400, 6900800);

        List<Account> expected = new ArrayList<>();
        expected.add(currentOne);

        customer.addAccount(currentOne);
        Assertions.assertEquals(expected, customer.getAccounts());
    }

    @Test
    public void testDepositToAccount() {
        Customer customer = new Customer("Gustav Svennas");
        Account savingsOne = new SavingsAccount("savings1", 5400, 6900758);
        customer.addAccount(savingsOne);

        Assertions.assertTrue(customer.depositFounds(500, savingsOne, "25/01/2023"));
        Assertions.assertTrue(customer.depositFounds(64.37, savingsOne, "25/01/2023"));

        Assertions.assertEquals(564.37, customer.showCurrentBalance(savingsOne));
    }

    @Test
    public void testWithdrawFromAccountWithEnoughMoney() {
        Customer customer = new Customer("Gustav Svennas");
        Account savingsOne = new SavingsAccount("savings1", 5400, 6900758);
        customer.addAccount(savingsOne);

        Assertions.assertTrue(customer.depositFounds(500, savingsOne,"25/01/2023"));
        Assertions.assertTrue(customer.withdrawFounds(300, savingsOne, "25/01/2023"));
        Assertions.assertEquals(200, customer.showCurrentBalance(savingsOne));

        Account currentsOne = new CurrentAccount("current1", 5400, 6900800);
        customer.addAccount(currentsOne);

        Assertions.assertTrue(customer.depositFounds(200, currentsOne, "25/01/2023"));
        Assertions.assertTrue(customer.withdrawFounds(300, currentsOne, "25/01/2023"));
        Assertions.assertEquals(-100, customer.showCurrentBalance(currentsOne));
    }

    @Test
    public void testWithdrawFromAccountsWithNotEnoughMoney() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput = "Can't withdraw that much money from that account!\n";

        Customer customer = new Customer("Gustav Svennas");
        Account savingsOne = new SavingsAccount("savings1", 5400, 6900758);
        customer.addAccount(savingsOne);

        Assertions.assertTrue(customer.depositFounds(200, savingsOne, "25/01/2023"));
        Assertions.assertFalse(customer.withdrawFounds(300, savingsOne, "25/01/2023"));
        Assertions.assertEquals(expectedOutput, outContent.toString());
        Assertions.assertEquals(200, customer.showCurrentBalance(savingsOne));

        final ByteArrayOutputStream outContentTwo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentTwo));
        Account currentsOne = new CurrentAccount("current1", 5400, 6900800);
        customer.addAccount(currentsOne);

        Assertions.assertTrue(customer.depositFounds(200, currentsOne, "25/01/2023"));
        Assertions.assertFalse(customer.withdrawFounds(400, currentsOne, "25/01/2023"));
        Assertions.assertEquals(expectedOutput, outContentTwo.toString());
        Assertions.assertEquals(200, customer.showCurrentBalance(currentsOne));
    }

    @Test
    public void testGetShortBankStatement() {
        String expectedOutput =
                "      date ||      credit ||       debit ||     balance \n" +
                "25/01/2023 ||             ||      300.01 ||       47.92 \n" +
                "24/01/2023 ||       97.03 ||             ||      347.93 \n" +
                "23/01/2023 ||      250.90 ||             ||      250.90 \n";

        Customer customer = new Customer("Gustav Svennas");
        Account savingsOne = new SavingsAccount("savings1", 5400, 6900758);
        customer.addAccount(savingsOne);

        customer.depositFounds(250.90, savingsOne,"23/01/2023");
        customer.depositFounds(97.03, savingsOne, "24/01/2023");
        customer.withdrawFounds(300.01, savingsOne, "25/01/2023");

        Assertions.assertEquals(expectedOutput, customer.printBankStatements(savingsOne));
    }

    @Test
    public void testGetBigBankStatement() {
        String expectedOutput =
                "      date ||      credit ||       debit ||     balance \n" +
                "25/01/2023 ||             ||    30000.01 ||   104700.92 \n" +
                "24/01/2023 ||     9700.03 ||             ||   134700.93 \n" +
                "23/01/2023 ||   125000.90 ||             ||   125000.90 \n";

        Customer customer = new Customer("Gustav Svennas");
        Account savingsOne = new SavingsAccount("savings1", 5400, 6900758);
        customer.addAccount(savingsOne);

        customer.depositFounds(125000.90, savingsOne,"23/01/2023");
        customer.depositFounds(9700.03, savingsOne, "24/01/2023");
        customer.withdrawFounds(30000.01, savingsOne, "25/01/2023");

        Assertions.assertEquals(expectedOutput, customer.printBankStatements(savingsOne));
    }

    @Test
    public void testAcceptanceCriteria() {
        String expectedOutput =
                "      date ||      credit ||       debit ||     balance \n" +
                "14/01/2012 ||             ||      500.00 ||     2500.00 \n" +
                "13/01/2012 ||     2000.00 ||             ||     3000.00 \n" +
                "10/01/2012 ||     1000.00 ||             ||     1000.00 \n";

        Customer customer = new Customer("Gustav Svennas");
        Account savingsOne = new SavingsAccount("savings1", 5400, 6900758);
        customer.addAccount(savingsOne);

        customer.depositFounds(1000.00, savingsOne,"10/01/2012");
        customer.depositFounds(2000.00, savingsOne, "13/01/2012");
        customer.withdrawFounds(500.00, savingsOne, "14/01/2012");

        Assertions.assertEquals(expectedOutput, customer.printBankStatements(savingsOne));
    }
}
