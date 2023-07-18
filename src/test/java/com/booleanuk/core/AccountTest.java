package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {

    @Test
    void addDeposit_ShouldAddToDepositAddBalanceNotNegative(){
        Account account = new Account();
        BigDecimal expectedBalance = BigDecimal.valueOf(200.50);

        Assertions.assertDoesNotThrow(() -> account.addDeposit(expectedBalance));
        Assertions.assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void addDeposit_ShouldNotAddToDepositAddBalanceNegative(){
        Account account = new Account();
        BigDecimal addBalance = BigDecimal.valueOf(-200.50);
        BigDecimal expectedBalance = BigDecimal.ZERO;

        Assertions.assertThrows(IllegalStateException.class, () -> account.addDeposit(addBalance));
        Assertions.assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void withDraw_ShouldNotWithdrawDepositWouldBeNegative(){
        Account account = new Account();
        BigDecimal expectedBalance = BigDecimal.valueOf(50);
        account.addDeposit(expectedBalance);

        Assertions.assertThrows(IllegalStateException.class, () -> account.withdraw(BigDecimal.valueOf(500)));
        Assertions.assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void withDraw_ShouldWithdraw(){
        Account account = new Account();
        BigDecimal expectedBalance = BigDecimal.ZERO;
        account.addDeposit(BigDecimal.valueOf(50));

        Assertions.assertDoesNotThrow(() -> account.withdraw(BigDecimal.valueOf(50)));
        Assertions.assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void accountOperations_SizeShouldBe3(){
        Account account = new Account();
        account.addDeposit(BigDecimal.valueOf(50));
        account.addDeposit(BigDecimal.valueOf(50));
        account.addDeposit(BigDecimal.valueOf(50));

        int expectedSize = 3;

        Assertions.assertEquals(expectedSize, account.getAccountOperationsSize());
    }
}
