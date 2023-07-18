package com.booleanuk.extension;

import org.junit.jupiter.api.*;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void beforeEachTestMethod(){
        account = new Account();
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
        account.deposit(depositAmount1);
        account.deposit(depositAmount2);
        account.withdraw(withdrawAmount1);
        account.withdraw(withdrawAmount2);
        float checkBalanceResult = account.checkBalance();

        //Then
        Assertions.assertEquals(expectedResult, checkBalanceResult);
    }
}
