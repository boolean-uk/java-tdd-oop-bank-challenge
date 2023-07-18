package com.booleanuk.extension.user;

import com.booleanuk.core.user.Engineer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class EngineerTest {

    @Test
    public void shouldCalculateBalanceFromHistory() {
        Engineer engineer = new Engineer();
        engineer.openCurrentAccount();

        engineer.depositCurrentAccount(BigDecimal.valueOf(1000));
        engineer.depositCurrentAccount(BigDecimal.valueOf(4000));
        engineer.depositCurrentAccount(BigDecimal.valueOf(5000));

        engineer.withdrawCurrentAccount(BigDecimal.valueOf(1000));
        engineer.withdrawCurrentAccount(BigDecimal.valueOf(500));
        engineer.withdrawCurrentAccount(BigDecimal.valueOf(2000));

        BigDecimal balanceState = engineer.getCurrentAccount().getBalance();
        BigDecimal dynamicCalculatedBalance = engineer.calculateBalanceFromHistory();
        Assertions.assertEquals(balanceState, dynamicCalculatedBalance);

    }
}
