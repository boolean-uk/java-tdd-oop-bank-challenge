package com.booleanuk.core.statement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestBasicStatement {
    @Test
    public void testCellData() {
        LocalDate time = LocalDate.now();
        double balance = 100.20;

        Statement s = new DepositStatement(time, balance, 0);

        String r = s.cell(4).asString(10);
        String expected = time + "||          " + "||       0.0" + "||     " + 100.2 + "||";

        Assertions.assertEquals(expected, r);
    }
}
