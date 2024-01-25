package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class DepositStatementTest {

    @Test
    public void testDepositStatementInit() {
        LocalDate date = LocalDate.now();


        DepositStatement depositStatement = new DepositStatement(500, 2000);


        Assertions.assertEquals(date.getDayOfMonth(), depositStatement.getTransactionDate().getDayOfMonth());
        Assertions.assertEquals(500.00, depositStatement.getAmount());
        Assertions.assertEquals(2000.00, depositStatement.getBalance());

    }

    @Test
    public void getStatementAsStringCorrectlyFormatted() {

        LocalDate date = LocalDate.now();


        String testString = String.format("%-8s %2s %11s %8s %2s %9s\n",date,"||","||", "500.0","||","2000.0");
        DepositStatement depositStatement = new DepositStatement(500, 2000);
        Assertions.assertEquals(testString, depositStatement.getStatementAsString());

    }

}
