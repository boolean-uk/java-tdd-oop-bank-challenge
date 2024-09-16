package com.booleanuk.core.statement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class BasicStatement implements Statement {
    private final LocalDate date;
    private final double balance;

    public BasicStatement(LocalDate date, double balance) {
        this.date = date;
        this.balance = balance;
    }

    @Override
    public Cell cell(int column) {
        ArrayList<String> data = new ArrayList<>(column) {{
            add(date.toString());
            add(Double.toString(balance));
        }};

        IntStream.range(1, column - 1).forEach(i -> data.add(i, ""));

        return new Cell(data);
    }
}
