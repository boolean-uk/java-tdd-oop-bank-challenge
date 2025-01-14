package com.booleanuk.core;

import java.time.LocalDateTime;

public record Transaction(LocalDateTime transactionTime, String fromAccount, String toAccount, int value) {
}
