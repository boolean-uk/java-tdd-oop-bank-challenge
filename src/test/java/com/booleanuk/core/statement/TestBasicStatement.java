package com.booleanuk.core.statement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestBasicStatement {
    @Test
    public void testCellData() {
        LocalDate time = LocalDate.now();
        double balance = 100.20;

        Statement s = new BasicStatement(time, balance);

        String r = s.cellData(2).asString(1);
        String expected = time + "||" + 100.20 + "||";

        Assertions.assertEquals(expected, r);

        r = s.cellData(4).asString(10);
        expected = time + "||          " + "||          " + "||     " + 100.2 + "||";

        Assertions.assertEquals(expected, r);
    }
}
