package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class AccountTest {

    @Test
    public void createAccountWithGivenNumber() {
        //Check if an account is created correctly with default values with given number
        Account accountWithGivenNumber = new Account(1, 12345678);
        Assertions.assertEquals(12345678, accountWithGivenNumber.getAccountNumber());
        Assertions.assertEquals(0.0, accountWithGivenNumber.getBalance());
        Assertions.assertEquals(new ArrayList<Transaction>(), accountWithGivenNumber.getTransactions());
    }

    @Test
    public void testMakeTransactionDeposit() {
        Account account = new Account(1, 12345678);
        account.makeTransaction(100.0);
        Assertions.assertEquals(100.0, account.getBalance());
        Assertions.assertEquals("deposit", account.getTransactions().getFirst().getType());
    }

    @Test
    public void testMakeTransactionWithdrawal() {
        Account account = new Account( 1, 12345678);
        account.makeTransaction(500.0);
        account.makeTransaction(-100.0);
        Assertions.assertEquals(400.0, account.getBalance());
        Assertions.assertEquals("withdrawal", account.getTransactions().get(1).getType());
    }

    @Test
    public void testStatementGeneration() {
        Account account = new Account( 1, 12345678);
        account.makeTransaction(500.0);
        account.makeTransaction(-100.0);
        account.makeTransaction(150.0);
        String date = new SimpleDateFormat("yyyy.MM.dd HH:mm z").format(Calendar.getInstance().getTime());
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(String.format("%21s || %10s || %8s || %8s\n", "Date", "Withdrawal", "Deposit", "Balance"));
        stringbuilder.append(String.format("%21s || %10s || %8s || %8s\n", date, " ", "500.0", "500.0"));
        stringbuilder.append(String.format("%21s || %10s || %8s || %8s\n", date, "100.0", " ", "400.0"));
        stringbuilder.append(String.format("%21s || %10s || %8s || %8s\n", date, " ", "150.0", "550.0"));
        Assertions.assertEquals(0, stringbuilder.compareTo(account.generateStatement()));

    }







}
