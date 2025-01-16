package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TransactionTest {



    @Test
    public void testDate() {
        Transaction transaction = new Transaction(100);
        Assertions.assertEquals(new SimpleDateFormat("yyyy.MM.dd HH:mm z").format(Calendar.getInstance().getTime()),transaction.getDate());
    }
    @Test
    public void testSetType() {
        Transaction deposit = new Transaction(100.0);
        Assertions.assertEquals(Transaction.Type.DEPOSIT, deposit.getType());
        Assertions.assertEquals(100.0, deposit.getAmount());
        Transaction withdrawal = new Transaction((-100.0));
        Assertions.assertEquals(Transaction.Type.WITHDRAWAL, withdrawal.getType());
        Assertions.assertEquals(100.0, deposit.getAmount());
    }

    @Test
    public void testFormattingDeposit() {
        Transaction deposit = new Transaction(100.0);
        String date = new SimpleDateFormat("yyyy.MM.dd HH:mm z").format(Calendar.getInstance().getTime());
        String testString = String.format("%21s || %10s || %8s || ", date, " ", 100.0);
        Assertions.assertEquals(testString, deposit.toString());
    }

    @Test
    public void testFormattingWithdrawal() {
        Transaction withdrawal = new Transaction(-100.0);
        String date = new SimpleDateFormat("yyyy.MM.dd HH:mm z").format(Calendar.getInstance().getTime());
        String testString = String.format("%21s || %10s || %8s || ", date, 100.0, " ");
        Assertions.assertEquals(testString, withdrawal.toString());
    }

}
