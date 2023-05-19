package com.booleanuk.core.statement;

import java.util.ArrayList;
import java.util.List;

public class Statements {
    private final List<Statement> statements = new ArrayList<>();

    public void add(Statement statement) {
        statements.add(statement);
    }

    public String details() {
        List<String> headers = List.of(
                "date",
                "credit",
                "debit",
                "balance"
        );

        Cell topCell = new Cell(headers);

        StringBuilder result = new StringBuilder(topCell.asString(10) + "\n");

        statements.forEach(s -> result.append(s.cellData(headers.size()).asString(10) + "\n"));

        return result.toString();
    }
}
