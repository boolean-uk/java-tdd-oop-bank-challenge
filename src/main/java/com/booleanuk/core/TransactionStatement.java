package com.booleanuk.core;

public record TransactionStatement(double credit, double balance, String date, TransactionType type) {
}
