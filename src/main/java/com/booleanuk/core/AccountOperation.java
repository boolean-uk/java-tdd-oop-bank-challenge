package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public record AccountOperation(LocalDate dateOfOperation, BigDecimal balance, String typeOfOperation, BigDecimal money) {
    @Override
    public String toString() {
        return String.format("%-12s || %-8s || %-7s || %-8s", dateOfOperation,
                (Objects.equals(typeOfOperation, "credit") ? money : ""),
                (Objects.equals(typeOfOperation, "debit") ? money : ""),
                balance);
    }
}
