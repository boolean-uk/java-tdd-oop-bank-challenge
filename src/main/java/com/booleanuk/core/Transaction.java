package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Transaction(BigDecimal amount, LocalDate date) {
}
