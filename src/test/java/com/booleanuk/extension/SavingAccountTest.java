package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SavingAccountTest {

    SavingAccount account;

    @BeforeEach
    void setUp() {
        account = new SavingAccount(new BankBranch(), BigDecimal.valueOf(2));
    }

    @Test
    void shouldAddInterestsToAccount() {
        account.deposit(BigDecimal.valueOf(1000.00), LocalDate.of(2012, 1, 10));
        account.addInterests(LocalDate.of(2012, 2, 10));

        Assertions.assertEquals(0, BigDecimal.valueOf(1020.00).compareTo(account.getBalance()));

        account.setInterestRate(BigDecimal.valueOf(2.05));
        account.addInterests(LocalDate.of(2012, 3, 10));

        Assertions.assertEquals(0, BigDecimal.valueOf(1040.91).compareTo(account.getBalance()));
    }

    @Test
    void shouldThrowWhenInterestRateIsNegative() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> account.setInterestRate(BigDecimal.valueOf(-2.05))
        );
    }

}
