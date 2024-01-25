package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

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
        Assertions.assertEquals(23.54, bank.getBalance(jonSnowAccountNr));
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
    public void testBankStatement() {
        Bank bank = new Bank();
        String jonSnowAccountNr = bank.addAccount("Jon", "Snow", "Current Account", "Winterfell", 23.54);

        bank.deposit(jonSnowAccountNr, 568.9);
        double money = bank.withdraw(jonSnowAccountNr, 1000);
        money = bank.withdraw(jonSnowAccountNr, 50.9);
        bank.deposit(jonSnowAccountNr, 358.32);
        money = bank.withdraw(jonSnowAccountNr, 759.34);
        bank.deposit(jonSnowAccountNr, 128.12);

        Account jonSnowAccount = bank.getAccount(jonSnowAccountNr);

        Statement statement = new Statement(jonSnowAccount);

        String date = String.valueOf(LocalDate.now());

        statement.makeStatement();
        ArrayList<String> jonSnowBankStatement = statement.getBankStatement();

        Assertions.assertEquals("Account Type: Current Account    Bank Branch: Winterfell", jonSnowBankStatement.get(1));
        Assertions.assertEquals("|| " + date + " ||  568.9     ||            || 592.43     ||", jonSnowBankStatement.get(4));
        Assertions.assertEquals("|| " + date + " ||  358.32    ||            || 358.32     ||", jonSnowBankStatement.get(6));
        Assertions.assertEquals("|| " + date + " ||            ||  358.32    || 0.0        ||", jonSnowBankStatement.get(7));
        Assertions.assertEquals("|| " + date + " ||  128.12    ||            || 128.12     ||", jonSnowBankStatement.get(8));
        Assertions.assertEquals("|| Date       || Deposit    || Withdraw   || Balance    ||", jonSnowBankStatement.get(2));
    }


    @Test
    public void testCheckBranch() {
        Bank bank = new Bank();
        String jonSnowAccountNr = bank.addAccount("Jon", "Snow", "Current Account", "Winterfell", 23.54);

        Account jonSnowAccount = bank.getAccount(jonSnowAccountNr);

        Assertions.assertEquals("Winterfell", jonSnowAccount.getBranch());
    }
}
