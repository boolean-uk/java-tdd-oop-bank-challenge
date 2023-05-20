package com.booleanuk.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Locale;

public class OverdraftRequestTest {

    private static Account account;

    @BeforeAll
    public static void globalSetup() {
        Locale locale = new Locale("el", "GR");
        BankManager bankManager = new BankManager();
        Bank bank = new Bank("EuroBank", "100", locale, bankManager);
        Branch branch = new Branch("Athens", "2555", bank);
        Customer customer = new Customer("GR123456789", "AT12345", "Dimitris",
                "Tsimaras", LocalDate.parse("1992-04-04"), branch);
        account = new CurrentAccount(new BigDecimal("100"), customer);
    }

    @Test
    public void checkConstructor_IllegalArguments() {
        Assertions.assertDoesNotThrow(() -> new OverdraftRequest(new BigDecimal("200"), account));

        Assertions.assertThrows(NullPointerException.class,
                () -> new OverdraftRequest(null, account));

        Assertions.assertThrows(NullPointerException.class,
                () -> new OverdraftRequest(new BigDecimal("200"), null));

        Assertions.assertThrows(ArithmeticException.class,
                () -> new OverdraftRequest(new BigDecimal("-200"), account));
    }
}
