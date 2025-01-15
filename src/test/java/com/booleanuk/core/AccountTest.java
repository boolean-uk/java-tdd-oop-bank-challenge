package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AccountTest {

    @Test
    public void createAccountWithGivenNumber() {
        //Check if an account is created correctly with default values with given number
        Account accountWithGivenNumber = new Account(12345678);
        Assertions.assertEquals(12345678, accountWithGivenNumber.getAccountNumber());
        Assertions.assertEquals(0.0, accountWithGivenNumber.getBalance());
        Assertions.assertEquals(new ArrayList<Transaction>(), accountWithGivenNumber.getTransactions());
    }

    @Test
    public void createAccountWithoutGivenNumber() {
        //Check if an account is created correctly with default values without given number
        Account accountWithoutGivenNumber = new Account();
        Assertions.assertEquals(0.0, accountWithoutGivenNumber.getBalance());
        Assertions.assertEquals(new ArrayList<Transaction>(), accountWithoutGivenNumber.getTransactions());
        Assertions.assertTrue(accountWithoutGivenNumber.getAccountNumber() >= 10000000);
        Assertions.assertTrue(accountWithoutGivenNumber.getAccountNumber() < 99999999);
    }

    @Test
    public void testMakeTransactionDeposit() {
        Account account = new Account(12345678);
        account.makeTransaction(100.0);
        Assertions.assertEquals(100.0, account.getBalance());
        Assertions.assertEquals("deposit", account.getTransactions().getFirst().getType());
    }

    @Test
    public void testMakeTransactionWithdrawal() {
        Account account = new Account(12345678);
        account.makeTransaction(500.0);
        account.makeTransaction(-100.0);
        Assertions.assertEquals(400.0, account.getBalance());
        Assertions.assertEquals("withdrawal", account.getTransactions().getFirst().getType());
    }






}
