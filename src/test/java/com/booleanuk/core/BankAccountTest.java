package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    BankAccount currentAccount;

    @BeforeEach
    public void setUp() {
        currentAccount = new CurrentAccount();
    }

    @Test
    public void whenCalculateBalanceIsCalledOnEmptyAccount_returns0(){
        Assertions.assertEquals(0, currentAccount.calculateBalance());
    }

    @Test
    public void whenDepositMoneyIsCalled_balanceIncreases(){
        //When
        currentAccount.depositMoney(10);
        //Then
        Assertions.assertEquals(10, currentAccount.calculateBalance());
    }

    @Test
    public void whenWithdrawMoneyIsCalled_balanceDecreases(){
        //Given
        currentAccount.depositMoney(10);
        //When
        currentAccount.withdrawMoney(5);
        //Then
        double expected = 10 - 5;
        Assertions.assertEquals(expected, currentAccount.calculateBalance());
    }

}
