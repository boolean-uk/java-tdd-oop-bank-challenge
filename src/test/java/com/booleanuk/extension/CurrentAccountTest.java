package com.booleanuk.extension;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CurrentAccountTest {
    private CurrentAccount currentAccount;

    @BeforeEach
    public void beforeEachTestMethod(){
        currentAccount = new CurrentAccount();
    }

    @Order(1)
    @Test
    public void testCheckBalance_ShouldReturnCorrectBalance(){
        //Given
        float depositAmount1 = 1000F;
        float depositAmount2 = 1500F;
        float withdrawAmount1 = 200F;
        float withdrawAmount2 = 650F;
        float expectedResult = depositAmount1 + depositAmount2 - withdrawAmount1 - withdrawAmount2;

        //When
        currentAccount.deposit(depositAmount1);
        currentAccount.deposit(depositAmount2);
        currentAccount.withdraw(withdrawAmount1);
        currentAccount.withdraw(withdrawAmount2);
        float checkBalanceResult = currentAccount.checkBalance();

        //Then
        Assertions.assertEquals(expectedResult, checkBalanceResult);
    }

    @Order(2)
    @Test
    public void testWithdraw_ShouldReturnTrueAndBalanceShouldBeCorrect(){
        //Given
        float depositAmount = 1000F;
        float withdrawAmount1 = 300F;
        float withdrawAmount2 = 300F;
        float expectedResult = depositAmount - withdrawAmount1 - withdrawAmount2;

        //When
        currentAccount.deposit(depositAmount);
        currentAccount.withdraw(withdrawAmount1);
        boolean withdrawResult = currentAccount.withdraw(withdrawAmount2);
        float checkBalanceResult = currentAccount.checkBalance();

        //Then
        Assertions.assertTrue(withdrawResult);
        Assertions.assertEquals(expectedResult, checkBalanceResult);
    }

    @Order(3)
    @Test
    public void testWithdraw_WhenAmountNotValid_ShouldReturnFalseAndBalanceShouldNotChange(){
        //Given
        float depositAmount = 1000F;
        float invalidWithdrawAmount = -400F;

        //When
        currentAccount.deposit(depositAmount);
        boolean withdrawResult = currentAccount.withdraw(invalidWithdrawAmount);
        float checkBalanceResult = currentAccount.checkBalance();

        //Then
        Assertions.assertFalse(withdrawResult);
        Assertions.assertEquals(depositAmount, checkBalanceResult);
    }

    @Order(4)
    @Test
    public void testWithdraw_WhenBalanceIsLessThanAmount_ShouldReturnTrueAndBalanceShouldBeLessThanZero(){
        //Given
        float depositAmount = 1000F;
        float withdrawAmount = 1001F;
        float expectedResult = depositAmount - withdrawAmount;

        //When
        currentAccount.deposit(depositAmount);
        boolean withdrawResult = currentAccount.withdraw(withdrawAmount);
        float checkBalanceResult = currentAccount.checkBalance();

        //Then
        Assertions.assertTrue(withdrawResult);
        Assertions.assertEquals(expectedResult, checkBalanceResult);
    }
}
    
