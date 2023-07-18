package com.booleanuk.core.banking;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Value
public class BankTransaction {
    TransactionType transactionType;
    TransactionResult transactionResult;
    BigDecimal balanceBefore;
    BigDecimal amount;
    BigDecimal balanceAfter;
    Instant createdAt;
}
