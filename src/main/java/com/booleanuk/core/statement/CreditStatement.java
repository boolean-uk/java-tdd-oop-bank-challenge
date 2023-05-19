package com.booleanuk.core.statement;

import java.time.LocalDate;
import java.util.List;

public class CreditStatement extends BasicStatement {
    private final double credit;

    public CreditStatement(LocalDate date, double balance, double credit) {
        super(date, balance);
        this.credit = credit;
    }

    @Override
    public Cell cellData(int column) {
        Cell cell = super.cellData(column);
        cell.updateColumn(1, Double.toString(credit));

        return cell;
    }
}
