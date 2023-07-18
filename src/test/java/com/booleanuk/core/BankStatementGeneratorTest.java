package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankStatementGeneratorTest {

    @Test
    public void bankStatementGeneratorTest(){
        Account account = new Account("Jan Lisek","00003");
        account.depositMoney(1000);
        account.withdrawMoney(300);
        account.depositMoney(5000);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = LocalDate.now().format(formatter);
        String expectedStatement = "date       || credit  || debit  || balance \n" +
                date + " || 1000.00 ||        || 1000.00\n" +
                date + " ||         || 300.00 ||  700.00\n" +
                date + " || 5000.00 ||        || 5700.00\n";

        Assertions.assertEquals(expectedStatement, account.generateBankStatement());
    }
}
