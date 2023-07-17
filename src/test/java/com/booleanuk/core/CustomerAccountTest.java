package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerAccountTest {

    @Test
    void shouldBeCredit() {
        CustomerAccount customerAccount = new CustomerAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch");

        Assertions.assertEquals(ACCOUNTTYPE.CREDIT, customerAccount.getType());
        Assertions.assertEquals("AccountName",customerAccount.getAccountName());
    }

    @Test
    void shouldBeSavings() {
        CustomerAccount customerAccount = new CustomerAccount(ACCOUNTTYPE.SAVINGS,"AccountName","BankBranch");

        Assertions.assertEquals(ACCOUNTTYPE.SAVINGS, customerAccount.getType());
        Assertions.assertEquals("AccountName",customerAccount.getAccountName());
    }

    @Test
    void shouldDepositTrue100() {
        CustomerAccount customerAccount = new CustomerAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch");
        Assertions.assertTrue(customerAccount.deposit(100));
        Assertions.assertEquals(100.0, customerAccount.statements.get(0).getBalance());
    }

    @Test
    void shouldWithdrawTrue() {
        CustomerAccount customerAccount = new CustomerAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch");
        Assertions.assertTrue(customerAccount.deposit(100));
        Assertions.assertTrue(customerAccount.withdraw(50));
        Assertions.assertEquals(50, customerAccount.statements.get(1).getBalance());
    }

    @Test
    void shouldWithdrawFalse() {
        CustomerAccount customerAccount = new CustomerAccount(ACCOUNTTYPE.CREDIT,"AccountName","BankBranch");
        Assertions.assertFalse(customerAccount.withdraw(50));
        Assertions.assertTrue(customerAccount.deposit(100));
        Assertions.assertFalse(customerAccount.withdraw(101));
    }
}
