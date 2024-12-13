package com.booleanuk.core;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @BeforeEach
    public void beforeEachTestMethod(){
        savingsAccount = new SavingsAccount();
    }

    @Order(1)
    @Test
    public void testDeposit_ShouldReturnTrueAndBalanceShouldBeCorrect(){
        //Given
        float depositAmount1 = 1000F;
        float depositAmount2 = 1500F;
        float expectedResult = depositAmount1 + depositAmount2;

        //When
        savingsAccount.deposit(depositAmount1);
        boolean depositResult = savingsAccount.deposit(depositAmount2);
        float checkBalanceResult = savingsAccount.checkBalance();

        //Then
        Assertions.assertTrue(depositResult);
        Assertions.assertEquals(expectedResult, checkBalanceResult);
    }

    @Order(2)
    @Test
    public void testDeposit_WhenAmountNotValid_ShouldReturnFalseAndBalanceShouldNotChange(){
        //Given
        float depositAmount = 1000F;
        float invalidDepositAmount = -1500F;

        //When
        savingsAccount.deposit(depositAmount);
        boolean depositResult = savingsAccount.deposit(invalidDepositAmount);
        float checkBalanceResult = savingsAccount.checkBalance();

        //Then
        Assertions.assertFalse(depositResult);
        Assertions.assertEquals(depositAmount, checkBalanceResult);
    }

    @Order(3)
    @Test
    public void testWithdraw_ShouldReturnTrueAndBalanceShouldBeCorrect(){
        //Given
        float depositAmount = 1000F;
        float withdrawAmount1 = 300F;
        float withdrawAmount2 = 300F;
        float expectedResult = depositAmount - withdrawAmount1 - withdrawAmount2;

        //When
        savingsAccount.deposit(depositAmount);
        savingsAccount.withdraw(withdrawAmount1);
        boolean withdrawResult = savingsAccount.withdraw(withdrawAmount2);
        float checkBalanceResult = savingsAccount.checkBalance();

        //Then
        Assertions.assertTrue(withdrawResult);
        Assertions.assertEquals(expectedResult, checkBalanceResult);
    }

    @Order(4)
    @Test
    public void testWithdraw_WhenAmountNotValid_ShouldReturnFalseAndBalanceShouldNotChange(){
        //Given
        float depositAmount = 1000F;
        float invalidWithdrawAmount = -400F;

        //When
        savingsAccount.deposit(depositAmount);
        boolean withdrawResult = savingsAccount.withdraw(invalidWithdrawAmount);
        float checkBalanceResult = savingsAccount.checkBalance();

        //Then
        Assertions.assertFalse(withdrawResult);
        Assertions.assertEquals(depositAmount, checkBalanceResult);
    }

    @Order(5)
    @Test
    public void testWithdraw_WhenBalanceIsLessThanAmount_ShouldReturnFalseAndBalanceShouldNotChange(){
        //Given
        float depositAmount = 1000F;
        float withdrawAmount = 1001F;

        //When
        savingsAccount.deposit(depositAmount);
        boolean withdrawResult = savingsAccount.withdraw(withdrawAmount);
        float checkBalanceResult = savingsAccount.checkBalance();

        //Then
        Assertions.assertFalse(withdrawResult);
        Assertions.assertEquals(depositAmount, checkBalanceResult);
    }

    @Order(6)
    @Test
    public void testGenerateBankStatement_ShouldReturnGeneratedStatement(){
        //Given
        float depositAmount1 = 1000F;
        float depositAmount2 = 2000F;
        float withdrawAmount = 500F;
        LocalDate localDate = LocalDate.now();
        StringBuilder bankStatement = new StringBuilder();

        bankStatement
                .append("date      || credit  || debit  || balance\n")
                .append(localDate.getDayOfMonth() + "/" + localDate.getMonthValue() + "/" + localDate.getYear() + " || " + "       " + " || " + "500.00" + " || " + "2500.00\n")
                .append(localDate.getDayOfMonth() + "/" + localDate.getMonthValue() + "/" + localDate.getYear() + " || " + "2000.00" + " || " + "      " + " || " + "3000.00\n")
                .append(localDate.getDayOfMonth() + "/" + localDate.getMonthValue() + "/" + localDate.getYear() + " || " + "1000.00" + " || " + "      " + " || " + "1000.00\n");

        String expectedResult = bankStatement.toString();

        //When
        savingsAccount.deposit(depositAmount1);
        savingsAccount.deposit(depositAmount2);
        savingsAccount.withdraw(withdrawAmount);
        String generateBankStatementResult = savingsAccount.generateBankStatement();

        //Then
        Assertions.assertEquals(expectedResult, generateBankStatementResult);
    }
}