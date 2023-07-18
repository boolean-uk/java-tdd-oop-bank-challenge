package com.booleanuk.core;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountTest {
    private Account account;

    @BeforeEach
    public void beforeEachTestMethod(){
        account = new Account();
    }

    @Order(1)
    @Test
    public void testDeposit_ShouldReturnTrueAndBalanceShouldBeCorrect(){
        //When
        account.deposit(1000F);
        boolean depositResult = account.deposit(1500F);
        float checkBalanceResult = account.checkBalance();

        //Then
        Assertions.assertTrue(depositResult);
        Assertions.assertEquals(2500, checkBalanceResult);
    }

    @Order(2)
    @Test
    public void testDeposit_WhenAmountNotValid_ShouldReturnFalseAndBalanceShouldNotChange(){
        //When
        account.deposit(1000F);
        boolean depositResult = account.deposit(-1500F);
        float checkBalanceResult = account.checkBalance();

        //Then
        Assertions.assertFalse(depositResult);
        Assertions.assertEquals(1000, checkBalanceResult);
    }

    @Order(3)
    @Test
    public void testWithdraw_ShouldReturnTrueAndBalanceShouldBeCorrect(){
        //When
        account.deposit(1000F);
        account.withdraw(300F);
        boolean withdrawResult = account.withdraw(400F);
        float checkBalanceResult = account.checkBalance();

        //Then
        Assertions.assertTrue(withdrawResult);
        Assertions.assertEquals(300, checkBalanceResult);
    }
}
