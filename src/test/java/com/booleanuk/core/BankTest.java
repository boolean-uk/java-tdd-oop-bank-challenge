package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class BankTest {

    @Test
    public void addAccount() {
        Bank bank = new Bank();

        CurrentAccount currentAccount = new CurrentAccount("G25097362", 1000.0);
        bank.addAccount(currentAccount);
        Assertions.assertEquals(1, bank.getAccounts().size());

        SavingsAccount savingsAccount = new SavingsAccount("S47382546", 2000.0);
        bank.addAccount(savingsAccount);
        Assertions.assertEquals(2, bank.getAccounts().size());
    }

    @Test
    public void deposit() {
        Bank bank = new Bank();

        CurrentAccount currentAccount = new CurrentAccount("G25097362", 1000.0);
        SavingsAccount savingsAccount = new SavingsAccount("S47382546", 2000.0);

        bank.addAccount(currentAccount);
        bank.addAccount(savingsAccount);

        currentAccount.deposit(0, new Date());
        Assertions.assertEquals(1000.0, currentAccount.balance);

        currentAccount.deposit(500.0, new Date());
        savingsAccount.deposit(130.0, new Date());

        Assertions.assertEquals(1500.0, currentAccount.balance);
        Assertions.assertEquals(2130.0, savingsAccount.balance);
    }

    @Test
    public void withdraw() {
        Bank bank = new Bank();

        CurrentAccount currentAccount = new CurrentAccount("G25097362", 1000.0);
        SavingsAccount savingsAccount = new SavingsAccount("S47382546", 2000.0);

        bank.addAccount(currentAccount);
        bank.addAccount(savingsAccount);

        currentAccount.withdraw(0, new Date());
        Assertions.assertEquals(1000.0, currentAccount.balance);

        currentAccount.withdraw(300.0, new Date());
        savingsAccount.withdraw(1000.0, new Date());

        Assertions.assertEquals(700.0, currentAccount.balance);
        Assertions.assertEquals(1000.0, savingsAccount.balance);
    }

    @Test
    public void bankStatement() {
        Bank bank = new Bank();

        CurrentAccount currentAccount = new CurrentAccount("G25097362", 0);

        bank.addAccount(currentAccount);

        currentAccount.deposit(1000.0, new Date(112,0,10));
        currentAccount.deposit(2000.0, new Date(112,0,13));
        currentAccount.withdraw(500.0, new Date(112,0,14));

        bank.bankStatement(currentAccount);
    }

    @Test
    public void printBalance() {
        Bank bank = new Bank();

        CurrentAccount currentAccount = new CurrentAccount("G25097362", 1000.0);
        SavingsAccount savingsAccount = new SavingsAccount("S47382546", 2000.0);

        bank.addAccount(currentAccount);
        bank.addAccount(savingsAccount);

        currentAccount.deposit(1000.0, new Date(112,0,10));
        currentAccount.deposit(2000.0, new Date(112,0,13));
        currentAccount.withdraw(500.0, new Date(112,0,14));

        Assertions.assertEquals(2500.0, bank.printBalance(currentAccount));

        currentAccount.withdraw(200.0, new Date());
        Assertions.assertEquals(2300.0, bank.printBalance(currentAccount));
    }
}
