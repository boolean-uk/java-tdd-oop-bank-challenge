package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class TestBank {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void TestCurrentAccountCreated() {
        Bank bank = new Bank();
        Customer customer = new Customer(1, "Harry", "Potter");
        bank.addCustomer(customer);
        Assertions.assertTrue(bank.createAccount(customer.getId(), "Current Account", 100.0));
    }

    @Test
    public void TestDeposit() {
        Bank bank = new Bank();
        Customer customer = new Customer(1, "Harry", "Potter");
        bank.addCustomer(customer);
        bank.createAccount(customer.getId(), "Saving Account", 0.0);
        int accountNumberForDeposit = customer.getNextAccountNumber() - 1;
        Assertions.assertTrue(bank.deposit(customer.getId(), accountNumberForDeposit, 100.0));
    }

    @Test
    public void TestTransactionPrint() {
        Bank bank = new Bank();
        Customer customer = new Customer(1, "Harry", "Potter");
        bank.addCustomer(customer);
        bank.createAccount(customer.getId(), "Saving Account", 0.0);
        int accountNumberForDeposit = customer.getNextAccountNumber() - 1;
        bank.deposit(customer.getId(), accountNumberForDeposit, 100.0);
        bank.deposit(customer.getId(), accountNumberForDeposit, 100.0);
        bank.deposit(customer.getId(), accountNumberForDeposit, 100.0);
        System.setOut(new PrintStream(outContent));
        bank.printBankStatement(customer.getId(), accountNumberForDeposit);
        Assertions.assertTrue(outContent.toString().contains("Credit: 100.0\nBalance: 300.0"));
    }

    @Test
    public void TestWithdraw() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Bank bank = new Bank();
        Customer customer = new Customer(1, "Harry", "Potter");
        bank.addCustomer(customer);
        bank.createAccount(1, "Saving Account", 300.0);

        int accountNumberForDeposit = 1;

        Assertions.assertTrue(bank.withdraw(customer.getId(), accountNumberForDeposit, 300.0));
        bank.printBankStatement(customer.getId(), accountNumberForDeposit);
        String output = outContent.toString();
        Assertions.assertTrue(output.contains("Balance: 0.0"));
        System.setOut(System.out);
    }
    @Test
    public void testBalanceBasedOnTransactionHistory() {
        // Initialize bank and customer
        Bank bank = new Bank();
        Customer customer = new Customer(1, "Ateeb", "Salam");
        bank.addCustomer(customer);
        bank.createAccount(customer.getId(), "Checking", 500.0);
        bank.deposit(customer.getId(), 1, 200.0); // Deposit 200
        bank.withdraw(customer.getId(), 1, 150.0); // Withdraw 150

        double balance = bank.findCustomerById(customer.getId()).getAccount(1).calculateBalance();

        Assertions.assertEquals(550.0, balance, "Balance should be calculated based on transaction history.");
    }

}
