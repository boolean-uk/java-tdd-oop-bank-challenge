package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankSystemTest {

    @Test
    public void makeDepositTest() {
        BankSystem bank = new BankSystem();
        Account acc = bank.createBankAccount(AccountType.CURRENT);
        Assertions.assertNotEquals(null, bank.makeDeposit(acc.getID(), 200.0F));
    }

    @Test
    public void makeDepositAndCheckTransactionAmountTest() {
        BankSystem bank = new BankSystem();
        Account acc = bank.createBankAccount(AccountType.CURRENT);
        Transaction transaction = bank.makeDeposit(acc.getID(), 200.0F);
        Assertions.assertEquals(200.0F, transaction.getAmount());
    }

    @Test
    public void makeDepositAndCheckWrongTransactionAmountTest() {
        BankSystem bank = new BankSystem();
        Account acc = bank.createBankAccount(AccountType.CURRENT);
        Transaction transaction = bank.makeDeposit(acc.getID(), 200.0F);
        Assertions.assertNotEquals(0F, transaction.getAmount());
    }

    @Test
    public void checkDepositIsLoggedCorrectlyTest() {
        BankSystem bank = new BankSystem();
        Account acc = bank.createBankAccount(AccountType.CURRENT);
        Transaction transaction = bank.makeDeposit(acc.getID(), 200.0F);
        Assertions.assertEquals(transaction.getID(), bank.transactionMap.get(acc.getID()).get(0).getID());
    }

    @Test
    public void checkDepositIsLoggedCorrectlyTest2() {
        BankSystem bank = new BankSystem();
        Account acc = bank.createBankAccount(AccountType.CURRENT);
        Transaction transaction1 = bank.makeDeposit(acc.getID(), 200.0F);
        Transaction transaction2 = bank.makeDeposit(acc.getID(), 500.0F);
        Assertions.assertEquals(transaction2.getAmount(), bank.transactionMap.get(acc.getID()).get(1).getAmount());
    }

    @Test
    public void makeWithdrawalAndCheckTransactionAmountTest() {
        BankSystem bank = new BankSystem();
        Account acc = bank.createBankAccount(AccountType.CURRENT);
        acc.deposit(500F);
        Transaction transaction = bank.makeWithdrawal(acc.getID(), 400.0F);
        Assertions.assertEquals(-400.0F, transaction.getAmount());
    }

    @Test
    public void generateStatementTest() {
        BankSystem bank = new BankSystem();
        Account acc = bank.createBankAccount(AccountType.CURRENT);
        bank.makeDeposit(acc.getID(), 200.0F);
        bank.makeDeposit(acc.getID(), 500.0F);
        bank.makeDeposit(acc.getID(), 500.0F);
        bank.makeWithdrawal(acc.getID(), 300.0F);
        System.out.println(bank.generateStatement(acc.getID()));
    }
}
