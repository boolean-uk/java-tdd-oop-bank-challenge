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
    public Cell cell(int column) {
        Cell cell = super.cell(column);
        cell.updateColumn(2, Double.toString(deposit));

        return cell;
    }

    @Override
    public double amount() {
        return deposit;
    }
}