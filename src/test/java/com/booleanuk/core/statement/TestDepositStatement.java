package com.booleanuk.core.statement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestDepositStatement {
    @Test
    public void testCellData() {
        LocalDate time = LocalDate.now();
        double balance = 100.20;
        double deposit = 20.10;

        Statement s = new DepositStatement(time, balance, deposit);

        String r = s.cellData(4).asString(10);
        String expected = time + "||          " + "||      " + deposit + "||     " + 100.2 + "||";

        Assertions.assertEquals(expected, r);
    }
}
