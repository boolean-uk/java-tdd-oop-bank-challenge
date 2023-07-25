package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankStatementGeneratorTest {

    @Test
    public void generateBankStatementTest() {
        CurrentAccount currentAccount =
                new CurrentAccount();
        currentAccount.deposit(4000);
        currentAccount.deposit(3200);
        currentAccount.deposit(500);
        currentAccount.withdraw(2563);
        currentAccount.deposit(235600);

        BankStatementGenerator bankStatementGenerator =
                new BankStatementGenerator();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String date = LocalDateTime.now().format(format);

        String expectedBankStatement = "date       || credit  || debit || balance\n" +
                                       "%s || 2356.00 ||       || 2407.37\n".formatted(date) +
                                       "%s ||         || 25.63 || 51.37  \n".formatted(date) +
                                       "%s || 5.00    ||       || 77.00  \n".formatted(date) +
                                       "%s || 32.00   ||       || 72.00  \n".formatted(date) +
                                       "%s || 40.00   ||       || 40.00  ".formatted(date);

        assertEquals(
                expectedBankStatement,
                bankStatementGenerator.generateBankStatement(
                        currentAccount.getTransactions()
                )
        );

        System.out.println(bankStatementGenerator.generateBankStatement(
                currentAccount.getTransactions()
        ));
    }
}
