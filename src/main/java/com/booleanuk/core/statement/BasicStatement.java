package com.booleanuk.core.statement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BasicStatement implements Statement {
    private final LocalDate date;
    private final double balance;

    public BasicStatement(LocalDate date, double balance) {
        this.date = date;
        this.balance = balance;
    }

    public Cell cellData(int column) {
        return new Cell(List.of(""));
    }
}
