package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transaction(
        LocalDateTime date,
        BigDecimal credit,
        BigDecimal debit,
        BigDecimal balance
) {
}
