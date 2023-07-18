package com.booleanuk.extensions;

import com.booleanuk.core.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {

    @Test
    void addDeposit_ShouldAddToDepositAddBalanceNotNegative(){
        com.booleanuk.core.Account account = new com.booleanuk.core.Account();
        BigDecimal expectedBalance = BigDecimal.valueOf(200.50);

        Assertions.assertDoesNotThrow(() -> account.addDeposit(expectedBalance));
        Assertions.assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void addDeposit_ShouldNotAddToDepositAddBalanceNegative(){
        com.booleanuk.core.Account account = new com.booleanuk.core.Account();
        BigDecimal addBalance = BigDecimal.valueOf(-200.50);
        BigDecimal expectedBalance = BigDecimal.ZERO;

        Assertions.assertThrows(IllegalStateException.class, () -> account.addDeposit(addBalance));
        Assertions.assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void withDraw_ShouldNotWithdrawDepositWouldBeNegative(){
        com.booleanuk.core.Account account = new com.booleanuk.core.Account();
        BigDecimal expectedBalance = BigDecimal.valueOf(50);
        account.addDeposit(expectedBalance);

        Assertions.assertThrows(IllegalStateException.class, () -> account.withdraw(BigDecimal.valueOf(500)));
        Assertions.assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    void withDraw_ShouldWithdraw(){
        com.booleanuk.core.Account account = new Account();
        BigDecimal expectedBalance = BigDecimal.ZERO;
        account.addDeposit(BigDecimal.valueOf(50));

        Assertions.assertDoesNotThrow(() -> account.withdraw(BigDecimal.valueOf(50)));
        Assertions.assertEquals(expectedBalance, account.getBalance());
    }
}
