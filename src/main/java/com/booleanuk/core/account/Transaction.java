package com.booleanuk.core.account;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public record Transaction(
    Type type,
    BigDecimal amount,
    ZonedDateTime timestamp
) {
    public static Transaction of(Type type, BigDecimal amount) {
        return new Transaction(type, amount, ZonedDateTime.now());
    }

    @RequiredArgsConstructor
    @Getter
    public enum Type {
        Deposit(1),
        Withdrawal(-1);

        private final int modifier;
    }
}
