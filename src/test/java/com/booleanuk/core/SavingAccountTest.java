package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SavingAccountTest {
    @Test
    public void withdrawAmountAndDateGivenWhenBalanceNegativeTest() {
        Bank bank = new Bank();
        SavingAccount account = new SavingAccount(bank);
        double amount1 = 500;
        double amount2 = 1500;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("01/12/2020", dateFormat);

        Assertions.assertEquals("Money added to deposit", account.deposit(amount1, date));
        Assertions.assertTrue(account.getCreditList().containsKey(date));
        Assertions.assertEquals(account.getCreditList().get(date).stream().filter(e -> e.equals(amount1)).findFirst().get(), amount1);
        Assertions.assertEquals("Saving account cannot have negative balance", account.withdraw(amount2, date));
    }

    @Test
    public void withdrawAmountGivenAndDateNotWhenBalanceNegativeTest() {
        Bank bank = new Bank();
        SavingAccount account = new SavingAccount(bank);
        double amount1 = 500;
        double amount2 = 1500;

        Assertions.assertEquals("Money added to deposit", account.deposit(amount1));
        Assertions.assertEquals("Saving account cannot have negative balance", account.withdraw(amount2));
    }
}
