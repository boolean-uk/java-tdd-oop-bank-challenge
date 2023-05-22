package com.booleanuk.core.statement;

public interface Statement {
    Cell cell(int columns);

    double amount();
}
