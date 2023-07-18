package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankStatementTest {

    @Test
    void shouldPrintBankStatement() {
        Account account = new CurrentAccount();
        account.deposit(BigDecimal.valueOf(1000.00), LocalDate.of(2012, 1, 10));
        account.deposit(BigDecimal.valueOf(2000.00), LocalDate.of(2012, 1, 13));
        account.withdraw(BigDecimal.valueOf(500.00), LocalDate.of(2012, 1, 14));

        BankStatement bankStatement = new BankStatement(account);
        Assertions.assertEquals("""
                date       || credit  || debit  || balance
                14/01/2012 ||         || 500.00 || 2500.00
                13/01/2012 || 2000.00 ||        || 3000.00
                10/01/2012 || 1000.00 ||        || 1000.00
                """, bankStatement.print());
    }
}
