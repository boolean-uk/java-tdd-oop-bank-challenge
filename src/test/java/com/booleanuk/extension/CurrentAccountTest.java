package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    private CurrentAccount currentAccount;

    @BeforeEach
    public void beforeEachTestMethod(){
        currentAccount = new CurrentAccount();
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
        currentAccount.deposit(depositAmount1);
        currentAccount.deposit(depositAmount2);
        currentAccount.withdraw(withdrawAmount1);
        currentAccount.withdraw(withdrawAmount2);
        float checkBalanceResult = currentAccount.checkBalance();

        //Then
        Assertions.assertEquals(expectedResult, checkBalanceResult);
    }
}
    
