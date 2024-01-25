package com.booleanuk.core;

public enum TransactionType {
    DEPOSIT, WITHDRAWAL, TRANSFER
    // I included TRANSFER.
    // This should be refactored so the enums have an attribute int multiplier -1 or 1 or boolean isSubtractive.

}
