package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {


    @Test
    void getCurrentName() {
        Account user1 = new Current("232323", "Hassan Hussain", 345.00);
        String result = user1.getName();
        Assertions.assertEquals("Hassan Hussain", result);



    }

    @Test
    void getSavingsName() {
        Account user1 = new Savings("232323", "Hassan Hussain", 345.00);
        String result = user1.getName();
        Assertions.assertEquals("Hassan Hussain", result);


    }

    @Test
    void testCreateCurrent() {
        Bank tester = new Bank();
        String result = tester.createCurrent();
        Assertions.assertEquals("Hassan Hussain", result);



    }

    @Test
    void testCreateSavings() {
        Bank tester = new Bank();
        String result = tester.createSavings();
        Assertions.assertEquals("Hassan Hussain", result);

    }


    @Test
    void testDepositTrue() {
        Account user1 = new Savings("232323", "Hassan Hussain", 345.00);
        boolean result = user1.deposit(50.00);
        Assertions.assertTrue(result);


    }


    @Test
    void testDepositFalse() {
        Account user1 = new Savings("232323", "Hassan Hussain", 345.00);
        boolean result = user1.deposit(1.00);
        Assertions.assertFalse(result);


    }

    @Test
    void testWithdrawalTrue() {
        Account user1 = new Current("232323", "Hassan Hussain", 345.00);
        boolean result = user1.withdrawal(50.00);
        Assertions.assertTrue(result);


    }

    @Test
    void testWithdrawalFalse() {
        Account user1 = new Current("232323", "Hassan Hussain", 20.00);
        boolean result = user1.withdrawal(50.00);
        Assertions.assertTrue(result);


    }






}
