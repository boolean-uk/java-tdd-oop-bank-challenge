package com.booleanuk.core.model;

import com.booleanuk.core.model.enumerations.TRANSACTION_TYPE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Locale;

public class TransactionTest {

    private static Locale locale;
    private static Money money;
    private static Account account;
    @BeforeAll
    public static void globalSetup() {
        locale = new Locale("el", "GR");
        money = new Money(new BigDecimal(BigInteger.TEN), locale);
        BankManager bankManager = new BankManager();
        Bank bank = new Bank("EuroBank", "100", locale, bankManager);
        Branch branch = new Branch("Athens", "2555", bank);
        Customer customer = new Customer("GR123456789", "AT12345", "Dimitris",
                "Tsimaras", LocalDate.parse("1992-04-04"), branch);
        account = new SavingsAccount(new BigDecimal(BigInteger.TEN), customer);
    }
    @Test
    public void checkConstructor_IllegalArguments() {
        Assertions.assertDoesNotThrow(() -> new Transaction(TRANSACTION_TYPE.DEPOSIT, money, account));
        Assertions.assertThrows(NullPointerException.class,
                () -> new Transaction(null, money, account));

        Assertions.assertThrows(NullPointerException.class,
                () -> new Transaction(TRANSACTION_TYPE.DEPOSIT, null, account));

        Assertions.assertThrows(NullPointerException.class,
                () -> new Transaction(TRANSACTION_TYPE.DEPOSIT, money, null));
    }

    @Test
    public void checkConstructor_NegativeOrZeroAmount() {
        Money positiveAmount = new Money(new BigDecimal(BigInteger.TEN), locale);
        Assertions.assertDoesNotThrow(() -> new Transaction(TRANSACTION_TYPE.DEPOSIT, positiveAmount, account));

        Money zeroAmount = new Money(new BigDecimal(BigInteger.ZERO), locale);
        Assertions.assertThrows(ArithmeticException.class,
                () -> new Transaction(TRANSACTION_TYPE.WITHDRAWAL, zeroAmount, account));

        Money negativeAmount = new Money(new BigDecimal("-0.5214"), locale);
        Assertions.assertThrows(NullPointerException.class,
                () -> new Transaction(null, negativeAmount, account));
    }
}
