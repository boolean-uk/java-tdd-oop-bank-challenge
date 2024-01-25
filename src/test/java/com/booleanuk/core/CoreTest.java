package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CoreTest {
    @Test
    void testDeposit() {
        Customer customer = new Customer("Sander",12345);
        CurrentAccount currentAccount = new CurrentAccount(customer);
        SavingsAccount savingsAccount = new SavingsAccount(customer);

        currentAccount.deposit(500,customer);
        savingsAccount.deposit(1000,customer);
        Assertions.assertEquals(500,currentAccount.getBalance());
        Assertions.assertEquals(1000,savingsAccount.getBalance());
        currentAccount.deposit(100,customer);
        Assertions.assertEquals(600,currentAccount.getBalance());

    }

    @Test
    void testWithdraw() {
        Customer customer = new Customer("Sander",12345);
        CurrentAccount currentAccount = new CurrentAccount(customer);
        SavingsAccount savingsAccount = new SavingsAccount(customer);


        currentAccount.deposit(500,customer);
        savingsAccount.deposit(1000,customer);
        currentAccount.withdraw(250,customer);
        Assertions.assertEquals(250,currentAccount.balance);
        savingsAccount.setLimit(-250);
        savingsAccount.withdraw(1200,customer);
        Assertions.assertEquals(-200,savingsAccount.getBalance());
        currentAccount.printStatement2();
    }

    @Test
    void testCustomerID(){
        Customer customer = new Customer("Alex",12345);
        Customer customer2 = new Customer("Sander", 54321);
        CurrentAccount currentAccount = new CurrentAccount(customer);
        SavingsAccount savingsAccount = new SavingsAccount(customer);
        currentAccount.deposit(500, customer);
        Assertions.assertEquals(500,currentAccount.getBalance());
        currentAccount.deposit(200,customer2);
        Assertions.assertEquals("Not your account", currentAccount.deposit(200,customer2));
        Assertions.assertEquals(500, currentAccount.getBalance());

    }

    @Test
    void testGenerateBankStatement() {
        Customer customer = new Customer("Sander", 12345);
        CurrentAccount currentAccount = new CurrentAccount(customer);


        currentAccount.deposit(1000.00, customer);
        currentAccount.withdraw(200.00, customer);
        currentAccount.deposit(500.00, customer);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));


        currentAccount.printStatement2();


        System.setOut(originalOut);


        String expectedStatement =
                "Date       || Credit  || Debit   || Balance \n" +
                        "----------------------------------------\n" +
                        currentAccount.transactions.get(2).getTimestamp()+" || 500.00  ||         || 1300.00 \n" +
                        currentAccount.transactions.get(1).getTimestamp()+" ||         || 200.00  || 800.00  \n" +
                        currentAccount.transactions.get(0).getTimestamp()+" || 1000.00 ||         || 1000.00 \n";

        // Compare the expected and actual outputs line by line
        String[] expectedLines = expectedStatement.split("\\r?\\n");
        String[] actualLines = outputStream.toString().split("\\r?\\n");


        for (int i = 0; i < expectedLines.length; i++) {
            Assertions.assertEquals(expectedLines[i], actualLines[i]);
        }

    }

}
