package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    @Test
    public void createAccount() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        Assertions.assertEquals(user, a.getOwner());
        Assertions.assertEquals(0, a.getTransactions().size());
        Assertions.assertEquals(0.00, a.getBalance());
    }

    @Test
    public void shouldReturnTrueDeposit() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        Assertions.assertTrue(a.deposit(20.00));
        Assertions.assertTrue(a.deposit(1.99));
        Assertions.assertEquals(21.99, a.getBalance());
    }

    @Test
    public void shouldReturnFalseDeposit() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        Assertions.assertFalse(a.deposit(-1.29));
        Assertions.assertFalse(a.deposit(0));
        Assertions.assertEquals(0.00, a.getBalance());
    }

    @Test
    public void shouldReturnTrueWithdraw() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        a.deposit(100.00);
        Assertions.assertTrue(a.withdraw(50.00));
        Assertions.assertTrue(a.withdraw(25.00));
        Assertions.assertEquals(25.00, a.getBalance());
        Assertions.assertTrue(a.withdraw(25.00));
    }

    @Test
    public void shouldReturnFalseWithdraw() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        a.deposit(50.00);
        Assertions.assertFalse(a.withdraw(100.00));
        Assertions.assertFalse(a.withdraw(-20.00));
        Assertions.assertEquals(50.00, a.getBalance());
    }

    @Test
    public void checkNewTransactionAfterDeposit() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        a.deposit(100.00);
        Assertions.assertEquals(1, a.getTransactions().size());
        Assertions.assertEquals(10000, a.transactions.get(0).getBalance());
        a.deposit(20.00);
        Assertions.assertEquals(12000, a.transactions.get(1).getBalance());
    }

    @Test
    public void checkNewTransactionAfterWithdraw() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        a.deposit(100.00);
        a.withdraw(20.00);
        Assertions.assertEquals(2, a.getTransactions().size());
        Assertions.assertEquals(-2000, a.transactions.get(1).getAmount());
        Assertions.assertEquals(8000, a.transactions.get(1).getBalance());
    }

    @Test
    public void getBankStatement() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        a.deposit(100.00);
        a.withdraw(20.00);
        Transaction transaction = a.transactions.get(0);
        Transaction transaction1 = a.transactions.get(1);
        String bankStatement = a.getBankStatement();
        Assertions.assertTrue(bankStatement.contains("Date\t\t\t\t|| Credit\t|| Debit\t|| Balance"));
        Assertions.assertTrue(bankStatement.contains(transaction.getDateTimeString() + "\t|| " + 100.00 + "\t|| " + "\t|| " + 100.00));
        Assertions.assertTrue(bankStatement.contains(transaction1.getDateTimeString() + "\t|| " + "\t|| " + 20.00 + "\t|| " + 80.00));
    }

    @Test
    public void getBankStatementEmpty() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        String bankStatement = a.getBankStatement();
        Assertions.assertEquals("No transactions made yet in this account.", bankStatement);
    }

}
