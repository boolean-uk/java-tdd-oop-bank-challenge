package com.booleanuk.core.statement;

import java.time.LocalDate;
import java.util.List;

public class DepositStatement extends BasicStatement {
    private final double deposit;

    public DepositStatement(LocalDate date, double balance, double deposit) {
        super(date, balance);
        this.deposit = deposit;
    }

    @Override
    public Cell cellData(int column) {
        return new Cell(List.of(""));
    }
}