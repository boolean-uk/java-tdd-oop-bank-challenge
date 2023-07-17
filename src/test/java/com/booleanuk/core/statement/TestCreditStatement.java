package com.booleanuk.core.statement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestCreditStatement {
    @Test
    public void testCellData() {
        LocalDate time = LocalDate.now();
        double balance = 100.20;
        double credit = 20.10;

        Statement s = new CreditStatement(time, balance, credit);

        String r = s.cell(4).asString(10);
        String expected = time + "||      " + credit + "||          " + "||     " + balance + "||";

        Assertions.assertEquals(expected, r);
    }
}
