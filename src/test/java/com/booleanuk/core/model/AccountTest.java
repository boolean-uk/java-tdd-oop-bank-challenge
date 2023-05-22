package com.booleanuk.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class AccountTest {

    private static Customer customer;

    @BeforeAll
    public static void globalSetup() {
        Locale locale = new Locale("el", "GR");
        BankManager bankManager = new BankManager();
        Bank bank = new Bank("EuroBank", "100", locale, bankManager);
        Branch branch = new Branch("Athens", "2555", bank);
        customer = new Customer("GR123456789", "AT12345", "Dimitris",
                "Tsimaras", LocalDate.parse("1992-04-04"), branch);
    }
    @Test
    public void checkDeposit_Withdrawal_getBalance() {
        Account current = new CurrentAccount(new BigDecimal("500"), customer);
        Assertions.assertEquals(new BigDecimal("500"),current.getBalance().getAmount());

        current.deposit(new BigDecimal("1000"));
        Assertions.assertEquals(new BigDecimal("1500"),current.getBalance().getAmount());

        current.withdraw(new BigDecimal("1200"));
        Assertions.assertEquals(new BigDecimal("300"),current.getBalance().getAmount());

        current.withdraw(new BigDecimal("1200"));
        Assertions.assertEquals(new BigDecimal("300"),current.getBalance().getAmount());

        current.withdraw(new BigDecimal("300"));
        Assertions.assertEquals(new BigDecimal("0"),current.getBalance().getAmount());
    }
}
