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
        String result = tester.createCurrent("232323", "Hassan Hussain", 333);
        Assertions.assertEquals("Your current account name is: Hassan Hussain", result);



    }

    @Test
    void testCreateSavings() {
        Bank tester = new Bank();
        String result = tester.createSavings("232323", "Hassan Hussain", 333);
        Assertions.assertEquals("Your savings account name is: Hassan Hussain", result);

    }


    @Test
    void testDepositTrue() {
        Bank tester = new Bank();
        boolean result = tester.deposit(50.00);
        Assertions.assertTrue(result);


    }


    @Test
    void testDepositFalse() {
        Bank tester = new Bank();
        boolean result = tester.deposit(50.00);
        Assertions.assertFalse(result);


    }

    @Test
    void testWithdrawalTrue() {
        Bank tester = new Bank();
        boolean result = tester.withdrawal(50.00);
        Assertions.assertTrue(result);


    }

    @Test
    void testWithdrawalFalse() {
        Bank tester = new Bank();
        boolean result = tester.withdrawal(50.00);
        Assertions.assertTrue(result);


    }






}
