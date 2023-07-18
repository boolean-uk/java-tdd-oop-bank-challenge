package com.booleanuk.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;

public class MoneyTest {

    @Test
    public void checkConstructor_IllegalArguments() {
        Locale locale = new Locale("el", "GR");
        BigDecimal amount = new BigDecimal(BigInteger.ZERO);

        Assertions.assertDoesNotThrow(() -> new Money(amount, locale));

        Assertions.assertThrows(NullPointerException.class,
                () -> new Money(null, locale));

        Assertions.assertThrows(NullPointerException.class,
                () -> new Money(amount, null));

        Assertions.assertThrows(NullPointerException.class,
                () -> new Money(null, null));
    }
}
