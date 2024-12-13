package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    SavingsAccount savingsAccount;

    @BeforeEach
    public void beforeEachTestMethod(){
        savingsAccount = new SavingsAccount();
    }

    @Test
    public void testCheckBalance_ShouldReturnCorrectBalance(){
        //Given
        float depositAmount1 = 1000F;
        float depositAmount2 = 1500F;
        float withdrawAmount1 = 200F;
        float withdrawAmount2 = 650F;
        float expectedResult = depositAmount1 + depositAmount2 - withdrawAmount1 - withdrawAmount2;

        //When
        savingsAccount.deposit(depositAmount1);
        savingsAccount.deposit(depositAmount2);
        savingsAccount.withdraw(withdrawAmount1);
        savingsAccount.withdraw(withdrawAmount2);
        float checkBalanceResult = savingsAccount.checkBalance();

        //Then
        Assertions.assertEquals(expectedResult, checkBalanceResult);
    }
}