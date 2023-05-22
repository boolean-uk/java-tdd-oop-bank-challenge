package com.booleanuk.core.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Money {

    private final BigDecimal amount;
    private final NumberFormat numberFormat;

    Money(BigDecimal amount, Locale locale) {
        if (amount == null || locale == null)
            throw new NullPointerException("All fields must be non-null.");

        this.amount = amount;
        this.numberFormat = NumberFormat.getCurrencyInstance(locale);
    }

    BigDecimal getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return numberFormat.format(this.amount);
    }
}
