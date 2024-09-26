package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class WithdrawStatementTest {

    @Test
    public void testDepositStatementInit() {
        LocalDate date = LocalDate.now();

        WithdrawStatement withdrawStatement = new WithdrawStatement(500, 2000);


        Assertions.assertEquals(date.getDayOfMonth(), withdrawStatement.getTransactionDate().getDayOfMonth());
        Assertions.assertEquals(500.00, withdrawStatement.getAmount());
        Assertions.assertEquals(2000.00, withdrawStatement.getBalance());

    }


    @Test
    public void getStatementAsStringCorrectlyFormatted() {

        LocalDate date = LocalDate.now();

        String testString = String.format("%-8s %2s %8s %2s %11s %9s\n",date,"||", "500.0","||","||","2000.0");

        WithdrawStatement withdrawStatement = new WithdrawStatement(500, 2000);


        Assertions.assertEquals(testString, withdrawStatement.getStatementAsString());
    }

}
