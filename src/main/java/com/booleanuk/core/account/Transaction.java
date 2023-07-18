package com.booleanuk.core.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public record Transaction(
        Type type,
        BigDecimal amount,
        ZonedDateTime timestamp
) {
    public static Transaction of(Type type, BigDecimal amount) {
        return new Transaction(type, amount, ZonedDateTime.now());
    }

    @Override
    public String toString() {
        var dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format(
                "|| %-10s || %10.2f || %10.2f ||",
                timestamp.format(dateFormat),
                type.equals(Type.Deposit) ? amount.doubleValue() : 0,
                type.equals(Type.Withdrawal) ? amount.doubleValue() : 0
        );
    }

    @RequiredArgsConstructor
    @Getter
    public enum Type {
        Deposit(1),
        Withdrawal(-1);

        private final int modifier;
    }
}
