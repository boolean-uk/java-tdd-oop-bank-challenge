package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void testCurrentAccountConstructor() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        Assertions.assertEquals("1", account.getAccountId());
        Assertions.assertEquals(customer, account.getCustomer());
        Assertions.assertEquals(branch, account.getBranch());
        Assertions.assertEquals(0.0, account.getBalance());
        Assertions.assertTrue(account.getTransactions().isEmpty());
        Assertions.assertEquals(0.0, account.getOverdraftLimit());
    }

    @Test
    public void testTransactionListInstantiated() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        account.getTransactions().add(new Transaction(new Date(),100, TransactionType.WITHDRAW ,1000));
        Assertions.assertFalse(account.getTransactions().isEmpty());
    }

    @Test
    public void testGetBankStatementWithTransaction() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        Date date = new Date();
        date.setTime(1706169421767L);
        account.getTransactions().add(new Transaction(date,100, TransactionType.DEPOSIT, 100));
        Assertions.assertEquals("Date                 || Credit   || Debit    || Balance  \n" +
                                        "2024-01-25 08:57:01  || 100.0    ||          || 100.0    ", account.getBankStatement());
    }

    @Test
    public void testGetBankStatementWithMultipleTransactions() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
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
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        Assertions.assertEquals("No transactions", account.getBankStatement());
    }

    @Test
    public void testDepositAndWithdrawFromAccountAndCheckTransactions() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        Assertions.assertEquals("$200.0 deposited", account.deposit(200));
        Assertions.assertTrue(account.getTransactions().stream().anyMatch(x->x.getAmount() == 200));
        Assertions.assertTrue(account.getTransactions().stream().anyMatch(x->x.getType().equals("Credit")));
        Assertions.assertEquals("Withdraw successful. $100.0 has been withdrawn", account.withdraw(100));
        Assertions.assertTrue(account.getTransactions().stream().anyMatch(x->x.getAmount() == 100));
        Assertions.assertTrue(account.getTransactions().stream().anyMatch(x->x.getType().equals("Debit")));
    }

    @Test
    public void testWithdrawFromAccountWithZeroBalance() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        Assertions.assertEquals("Withdraw failed. Amount withdrawn is more than balance in account", account.withdraw(200));
    }

    @Test
    public void testDepositNegativeAccount() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        Assertions.assertEquals("The amount cannot be a negative number", account.deposit(-1));

    }

    @Test
    public void testWithdrawNegativeAccount() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        Assertions.assertEquals("The amount cannot be a negative number", account.withdraw(-1));
    }

    @Test
    public void testGetBalanceZero() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        Assertions.assertEquals(0,account.getBalance());
    }

    @Test
    public void testGetBalanceOneTransaction() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        account.deposit(1000);
        Assertions.assertEquals(1000,account.getBalance());
    }

    @Test
    public void testGetBalanceMultipleTransaction() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        account.deposit(1000);
        account.deposit(1000);
        account.withdraw(500);
        Assertions.assertEquals(1000+1000-500,account.getBalance());
    }

    @Test
    public void testRequestOverdraft() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        Assertions.assertEquals("Overdraft of $500.0 requested",account.requestOverdraft(500));
        Assertions.assertTrue(branch.getOverdraftRequests().containsKey(account));
    }

    @Test
    public void testRequestOverdraftNegativeAmount() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        Assertions.assertEquals("Amount cannot be negative",account.requestOverdraft(-1));
    }

    @Test
    public void testSetOverdraftLimitPosNum() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        account.setOverdraftLimit(100);
        Assertions.assertEquals(100,account.getOverdraftLimit());
    }

    @Test
    public void testSetOverdraftLimitNegNum() {
        Customer customer = new Customer("1", "Java Man", "12345678", "java@man.coder");
        Branch branch = new Branch("1", "DNC", "London");
        Account account = new Account("1", customer, branch);
        account.setOverdraftLimit(-1);
        Assertions.assertEquals(0,account.getOverdraftLimit());
    }
}