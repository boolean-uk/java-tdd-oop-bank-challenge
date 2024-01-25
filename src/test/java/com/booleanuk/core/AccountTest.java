package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void testCurrentAccountConstructor() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Account account = new Account("1", customer);
        Assertions.assertEquals("1", account.getAccountId());
        Assertions.assertEquals(customer, account.getCustomer());
        Assertions.assertEquals(0.0, account.getBalance());
        Assertions.assertTrue(account.getTransactions().isEmpty());
    }

    @Test
    public void testTransactionListInstantiated() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Account account = new Account("1", customer);
        account.getTransactions().add(new Transaction(new Date(),100, TransactionType.WITHDRAW ,1000));
        Assertions.assertFalse(account.getTransactions().isEmpty());
    }

    @Test
    public void testGetBankStatementWithTransaction() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Account account = new Account("1", customer);
        Date date = new Date();
        date.setTime(1706169421767L);
        account.getTransactions().add(new Transaction(date,100, TransactionType.DEPOSIT, 100));
        Assertions.assertEquals("Date                 || Credit   || Debit    || Balance  \n" +
                                        "2024-01-25 08:57:01  || 100.0    ||          || 100.0    ", account.getBankStatement());
    }

    @Test
    public void testGetBankStatementWithMultipleTransactions() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Account account = new Account("1", customer);
        Date date = new Date();
        date.setTime(1706169421767L);
        Date date1 = new Date();
        date1.setTime(1706179445767L);
        Date date2 = new Date();
        date2.setTime(1706189426367L);
        account.getTransactions().add(new Transaction(date2,200, TransactionType.WITHDRAW, 900));
        account.getTransactions().add(new Transaction(date1,100, TransactionType.DEPOSIT, 1100));
        account.getTransactions().add(new Transaction(date,1000, TransactionType.DEPOSIT, 1000));
        Assertions.assertEquals(
                "Date                 || Credit   || Debit    || Balance  \n" +
                         "2024-01-25 14:30:26  ||          || 200.0    || 900.0    \n" +
                         "2024-01-25 11:44:05  || 100.0    ||          || 1100.0   \n" +
                         "2024-01-25 08:57:01  || 1000.0   ||          || 1000.0   ", account.getBankStatement());
    }

    @Test
    public void testGetBankStatementWithoutTransaction() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Account account = new Account("1", customer);
        Assertions.assertEquals("No transactions", account.getBankStatement());
    }
}