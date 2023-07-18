package com.booleanuk.core.statement;

import com.booleanuk.core.user.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;

public class BankStatementGeneratorTest {

    @Test
    public void shouldPrintStatementOrderedByDateDescending() {


        Customer customer = new Customer();
        customer.openCurrentAccount();

        customer.depositCurrentAccount(BigDecimal.valueOf(1000));
        customer.depositCurrentAccount(BigDecimal.valueOf(500));
        customer.depositCurrentAccount(BigDecimal.valueOf(100));

        customer.withdrawCurrentAccount(BigDecimal.valueOf(500));
        customer.withdrawCurrentAccount(BigDecimal.valueOf(300));
        customer.withdrawCurrentAccount(BigDecimal.valueOf(3000));

        BankStatementGenerator generator = new BankStatementGenerator();
        String result = generator.generateStatement(customer.getCurrentAccount().getTransactions());

        System.out.println(result);

    }

    @Test
    public void shouldPrintDateInProperFormat() {
        BankStatementGenerator generator = new BankStatementGenerator();

        Instant instant = Instant.parse("2022-02-15T18:35:24.00Z");

        String formattedInstant = generator.getFormatter().format(instant);
        Assertions.assertEquals("15/02/2022", formattedInstant);

    }

}
