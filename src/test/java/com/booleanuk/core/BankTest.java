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
        Account testAcc = new Current("232323", "ssss", 230);
        double result = tester.deposit(testAcc, 50.00);
        Assertions.assertEquals(280, result);


    }


    @Test
    void testDepositFalse() {
        Bank tester = new Bank();
        Account testAcc = new Current("232323", "ssss", 9.00);
        double result = tester.deposit(testAcc, 9.00);
        Assertions.assertEquals(9, result);


    }

    @Test
    void testWithdrawalTrue() {
        Bank tester = new Bank();
        Account testAcc = new Current("232323", "ssss", 900.00);
        double result = tester.withdrawal(testAcc, 50.00);
        Assertions.assertEquals(850, result);


    }

    @Test
    void testWithdrawalFalse() {
        Bank tester = new Bank();
        Account testAcc = new Current("232323", "ssss", 9.00);
        double result = tester.withdrawal(testAcc, 50.00);
        Assertions.assertEquals(0, result);


    }

    @Test
    void testGetDepositDate() {
        Bank tester = new Bank();
        Account testAcc = new Current("232323", "ssss", 9.00);
        double result = tester.withdrawal(testAcc, 50.00);
        Assertions.assertEquals(0, result);


    }

    @Test
    void testBankStatementsWithHistory() {
        Bank tester = new Bank();
        Account testAcc = new Current("232323", "ssss", 500.00);
        tester.withdrawal(testAcc, 50.00);
        tester.deposit(testAcc, 500.00);
        tester.withdrawal(testAcc, 200.00);
        tester.deposit(testAcc, 300.00);

        String result = tester.bankStatement();
        Assertions.assertEquals("shdhhfhsbehd", result);

    }

    @Test
    void testBankStatementsWithoutHistory() {
        Bank tester = new Bank();
        Account testAcc = new Current("232323", "ssss", 500.00);

        String result = tester.bankStatement();
        Assertions.assertEquals("You have no history.", result);


    }






}
