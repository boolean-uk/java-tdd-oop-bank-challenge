package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankStatementGeneratorTest {

    @Test
    public void bankStatementGeneratorTest(){
        BankStatementGenerator bankStatementGenerator = new BankStatementGenerator();
        Account account = new Account("Jan Lisek");
        account.depositMoney(1000);
        account.withdrawMoney(300);
        account.depositMoney(4000);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = LocalDate.now().format(formatter);
        StringBuilder expectedStatementBuilder = new StringBuilder();
        expectedStatementBuilder.append("date       || credit  || debit  || balance \n");
        expectedStatementBuilder.append(date).append(" || 1000,00 ||        || 1000,00\n");
        expectedStatementBuilder.append(date).append(" ||         || 300,00 ||  700,00\n");
        expectedStatementBuilder.append(date).append(" || 4000,00 ||        || 4700,00\n");

        Assertions.assertEquals(expectedStatementBuilder.toString(), bankStatementGenerator.generateBankStatement(account));
    }
}
