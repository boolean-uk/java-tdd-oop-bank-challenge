package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class AccountTest {

    Account savingsAccount = new SavingsAccount(new Customer("Bob Bagel", 1234));
    CurrentAccount currentAccount = new CurrentAccount(new Customer("Bob Bagel", 1234));

    @Test
    public void depositValidAmount() {
        Assertions.assertEquals(0, savingsAccount.getBalance());
        Assertions.assertTrue(savingsAccount.deposit(15));
        Assertions.assertEquals(15, savingsAccount.getBalance());
    }

    @Test
    public void depositInvalidAmount() {
        Assertions.assertEquals(0, savingsAccount.getBalance());
        Assertions.assertFalse(savingsAccount.deposit(-15));
        Assertions.assertEquals(0, savingsAccount.getBalance());
    }

    @Test
    public void withdrawValidAmount() {
        savingsAccount.deposit(30);
        Assertions.assertTrue(savingsAccount.withdraw(20));
        Assertions.assertEquals(10, savingsAccount.getBalance());
    }

    @Test
    public void withdrawMoreThanSavingsAccountHas() {
        savingsAccount.deposit(30);
        Assertions.assertFalse(savingsAccount.withdraw(40));
        Assertions.assertEquals(30, savingsAccount.getBalance());
    }

    @Test
    public void withdrawMoreThanCurrentAccountHas() {
        currentAccount.deposit(30);
        currentAccount.setAllowedOverdraft(20);
        Assertions.assertTrue(currentAccount.withdraw(40));
        Assertions.assertEquals(-10, currentAccount.getBalance());
    }

    @Test
    public void withdrawNegativeAmount() {
        Assertions.assertFalse(savingsAccount.withdraw(-40));
        Assertions.assertEquals(0, savingsAccount.getBalance());
    }

    @Test
    public void maintainingCorrectBalanceTest() {
        double a = 23.4322;
        double b = 343.32342;
        double c = 44.432;
        double d = 432.002001;
        double e = 22.119232;

        savingsAccount.deposit(a);
        savingsAccount.deposit(b);
        savingsAccount.deposit(b);
        savingsAccount.deposit(b);
        savingsAccount.withdraw(c);
        savingsAccount.deposit(d);
        savingsAccount.withdraw(e);

        double ans = a+b*3-c+d-e;

        Assertions.assertEquals(ans, savingsAccount.getBalance());
    }

    @Test
    public void getEmptyStatementsTest() {
        Assertions.assertEquals(new ArrayList<>(), savingsAccount.getStatements());
    }

    @Test
    public void getStatementsOneDepositPresentTest() {
        savingsAccount.deposit(23.231);
        Statement statement = new Statement(new Date(), 23.231);
        ArrayList<Statement> expected = new ArrayList<>(Arrays.asList(statement));
        Assertions.assertEquals(expected, savingsAccount.getStatements());
    }

    @Test
    public void getStatementsSeveralDepositsAndWithdrawalsPresentTest() {
        double a = 23.4322;
        double b = 343.32342;
        double c = 44.432;
        double d = 432.002001;
        double e = 22.119232;
        ArrayList<Statement> expected = new ArrayList<>();

        savingsAccount.deposit(a);
        expected.add(new Statement(new Date(), a));
        savingsAccount.deposit(b);
        expected.add(new Statement(new Date(), b));
        savingsAccount.withdraw(c);
        expected.add(new Statement(new Date(), c));
        savingsAccount.deposit(d);
        expected.add(new Statement(new Date(), d));
        savingsAccount.withdraw(e);
        expected.add(new Statement(new Date(), e));

        Assertions.assertEquals(expected, savingsAccount.getStatements());
    }

}
