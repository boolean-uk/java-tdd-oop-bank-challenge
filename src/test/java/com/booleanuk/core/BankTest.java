package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void testAddAccount() {
        Bank bank = new Bank();
        String jonSnowAccountNr = bank.addAccount("Jon", "Snow", "Current Account", "Winterfell", 23.54);
        Assertions.assertEquals("968736857", jonSnowAccountNr);
    }

    @Test
    public void testCheckAccountDetails() {
        Bank bank = new Bank();
        String jonSnowAccountNr = bank.addAccount("Jon", "Snow", "Current Account", "Winterfell", 23.54);

        Account jonSnowAccount = bank.getAccount(jonSnowAccountNr);

        Assertions.assertEquals("Winterfell", jonSnowAccount.getBranch());
        Assertions.assertEquals(23.54, jonSnowAccount.getBalance());
        Assertions.assertEquals("Current Account", jonSnowAccount.getType());
    }

    @Test
    public void testGetBalance() {
        Bank bank = new Bank();
        String jonSnowAccountNr = bank.addAccount("Jon", "Snow", "Current Account", "Winterfell", 23.54);

        double balance = bank.getBalance(jonSnowAccountNr);
        Assertions.assertEquals(23.54, balance);
    }

    @Test
    public void testDeposit() {
        Bank bank = new Bank();
        String jonSnowAccountNr = bank.addAccount("Jon", "Snow", "Current Account", "Winterfell", 23.54);

        bank.deposit(jonSnowAccountNr, 568.9);

        double balance = bank.getBalance(jonSnowAccountNr);
        Assertions.assertEquals(23.54+568.9, balance);
    }

    @Test
    public void testWithdraw() {
        Bank bank = new Bank();
        String jonSnowAccountNr = bank.addAccount("Jon", "Snow", "Current Account", "Winterfell", 23.54);

        bank.deposit(jonSnowAccountNr, 568.9);
        double money = bank.withdraw(jonSnowAccountNr, 34.56);

        double balance = bank.getBalance(jonSnowAccountNr);
        Assertions.assertEquals(23.54+568.9-34.56, balance);
    }

    @Test
    public void testOverdraw() {
        Bank bank = new Bank();
        String jonSnowAccountNr = bank.addAccount("Jon", "Snow", "Current Account", "Winterfell", 23.54);

        bank.deposit(jonSnowAccountNr, 568.9);
        double money = bank.withdraw(jonSnowAccountNr, 1000);

        double balance = bank.getBalance(jonSnowAccountNr);
        Assertions.assertEquals(0.0, balance);
        Assertions.assertEquals(23.54+568.9, money);
    }

    @Test
    public void testStatement() {
        Bank bank = new Bank();
        String jonSnowAccountNr = bank.addAccount("Jon", "Snow", "Current Account", "Winterfell", 23.54);

        bank.deposit(jonSnowAccountNr, 568.9);
        double money = bank.withdraw(jonSnowAccountNr, 1000);
        money = bank.withdraw(jonSnowAccountNr, 1000);
        bank.deposit(jonSnowAccountNr, 568.9);
        money = bank.withdraw(jonSnowAccountNr, 1000);
        bank.deposit(jonSnowAccountNr, 568.9);

        Account jonSnowAccount = bank.getAccount(jonSnowAccountNr);

        Statement statement = new Statement(jonSnowAccount);

        statement.makeStatement();

    }
}
