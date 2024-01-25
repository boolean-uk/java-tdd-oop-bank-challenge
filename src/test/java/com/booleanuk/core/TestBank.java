package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class TestBank {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Test
    public void TestCurrentAccountCreated(){
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date,0,0, "Debit");
        Account account = new Account("Current Account", 0, transaction);
        Customer customer = new Customer(1,"Harry","Potter",account);
        Bank bank = new Bank(customer);
        Assertions.assertTrue(bank.createAccount(customer.id, 100.0));
    }
    @Test
    public void TestSavingAccountCreated(){
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date,0,0, "Debit");
        Account account = new Account("Saving Account", 0,transaction);
        Customer customer = new Customer(1,"Harry","Potter",account);
        Bank bank = new Bank(customer);
        Assertions.assertTrue(bank.createSavingsAccount(customer.id, 100.0));
    }

    @Test
    public void TestDeposit(){
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date,0,0, "Debit");
        Account account = new Account("Saving Account", 0,transaction);
        Customer customer = new Customer(1,"Harry","Potter",account);
        Bank bank = new Bank(customer);

        // Assuming the first account number starts at 0
        int accountNumberForDeposit = 0;
        Assertions.assertTrue(bank.deposit(customer.id, accountNumberForDeposit, 100.0));
    }

    @Test
    public void TestTransactionPrint(){
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date,0,0, "Debit");
        Account account = new Account("Saving Account", 0,transaction);
        Customer customer = new Customer(1,"Harry","Potter",account);
        Bank bank = new Bank(customer);
        outContent.reset();
        System.setOut(new PrintStream(outContent));
        int accountNumberForDeposit = 0;
        bank.deposit(customer.id, accountNumberForDeposit, 100.0);
        bank.deposit(customer.id, accountNumberForDeposit, 100.0);
        bank.deposit(customer.id, accountNumberForDeposit, 100.0);
        bank.printBankStatement(customer.id, accountNumberForDeposit);
        Assertions.assertTrue(outContent.toString().trim().contains("Credit: 100.0\n" +
                        "Balance: 300.0"));
    }
    @Test
    public void TestWithdraw(){
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date,0,0, "Debit");
        Account account = new Account("Saving Account", 0,transaction);
        Customer customer = new Customer(1,"Harry","Potter",account);
        Bank bank = new Bank(customer);
        outContent.reset();
        System.setOut(new PrintStream(outContent));
        int accountNumberForDeposit = 0;
        bank.deposit(customer.id, accountNumberForDeposit, 100.0);
        bank.deposit(customer.id, accountNumberForDeposit, 100.0);
        bank.deposit(customer.id, accountNumberForDeposit, 100.0);
        Assertions.assertTrue(bank.withdraw(customer.id, accountNumberForDeposit, 100.0));
        Assertions.assertEquals("0.0", outContent.toString().trim());
    }
}
