package com.booleanuk.core.statement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.nimbus.State;
import java.time.LocalDate;
import java.util.List;

public class TestStatements {
    @Test
    public void testDetails() {
        LocalDate time = LocalDate.now();
        double balance = 100.20;
        double deposit = 40.20;
        double credit = 20.10;

        Statements statements = new Statements();
        statements.add(new DepositStatement(time, balance, deposit));
        statements.add(new CreditStatement(time, balance, credit));

        String r = statements.details();

        String expected = "      date||    credit||     debit||   balance||\n" +
                time + "||          ||      " + deposit + "||     " + balance + "||\n" +
                time + "||      " + credit + "||          " + "||     " + balance + "||\n";

        Assertions.assertEquals(expected, r);
    }
}
