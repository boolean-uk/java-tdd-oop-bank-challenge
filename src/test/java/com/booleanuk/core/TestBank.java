package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TestBank {

    @Test
    public void TestCurrentAccountCreated(){
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date,0,0);
        Account account = new Account("Current Account", 0, transaction);
        Customer customer = new Customer(1,"Harry","Potter",account);
        Bank bank = new Bank(customer);
        Assertions.assertTrue(bank.createAccount(customer.id, 100.0));
    }
    @Test
    public void TestSavingAccountCreated(){
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date,0,0);
        Account account = new Account("Saving Account", 0,transaction);
        Customer customer = new Customer(1,"Harry","Potter",account);
        Bank bank = new Bank(customer);
        Assertions.assertTrue(bank.createSavingsAccount(customer.id, 100.0));
    }

    @Test
    public void TestDeposit(){
        LocalDateTime date = LocalDateTime.now();
        Transaction transaction = new Transaction(date,0,0);
        Account account = new Account("Saving Account", 0,transaction);
        Customer customer = new Customer(1,"Harry","Potter",account);
        Bank bank = new Bank(customer);
        Assertions.assertTrue(bank.deposit(customer.id, account.accountType, 100.0));
    }
}
