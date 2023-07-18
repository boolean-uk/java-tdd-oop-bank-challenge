package com.booleanuk.core;

import com.booleanuk.core.enums.BANK_NAMES;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountTest {

    private static Customer customer;


    @BeforeAll
    public static void setup() {
        customer = new Customer("John", "Doe", LocalDate.parse("1990-01-01"));
    }

    @Test
    public void shouldOpenCurrentAccountWith0Balance() {
        Account current = new CurrentAccount(customer);
        Assertions.assertEquals(BigDecimal.ZERO,current.getBalance());
    }

    @Test
    public void shouldOpenCurrentAccount() {
        Account current = new CurrentAccount(new BigDecimal("1000"), customer);
        Assertions.assertEquals(new BigDecimal("1000"), current.getBalance());
    }
    @Test
    public void shouldOpenSavingsAccount() {
        Account savings = new SavingsAccount(new BigDecimal("1000"), customer);
        Assertions.assertEquals(new BigDecimal("1000"),savings.getBalance());
    }

    @Test
    public void shouldBeAbleToWithDraw() {
        Account current = new CurrentAccount(new BigDecimal("1000"), customer);
        current.withdraw(new BigDecimal("100"));
        Assertions.assertEquals(new BigDecimal("900"), current.getBalance());
    }
    @Test
    public void shouldBeAbleToDeposit() {
        Account current = new CurrentAccount(new BigDecimal("1000"), customer);
        current.deposit(new BigDecimal("500"));
        Assertions.assertEquals(new BigDecimal("1500"), current.getBalance());
    }

    @Test
    void withdraw_shouldThrowForInsufficientBalanceAndNotAddTransactionToHistory() {
        Account current = new CurrentAccount(customer);
        Assertions.assertThrows(IllegalStateException.class, () -> current.withdraw(BigDecimal.ONE),
                "Expected an IllegalStateException to be thrown for insufficient funds");
    }

}
