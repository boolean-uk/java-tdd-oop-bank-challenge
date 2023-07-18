package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

public class BankTest {

    @BeforeEach
    public void setup() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @Test
    public void testOperatingThroughBank() {
        Bank bank = new Bank();
        UUID customerId = bank.registerCustomer();
        UUID accountId = bank.openAccount(customerId, CurrentAccount.class);
        bank.deposit(accountId, BigDecimal.valueOf(1_000));
        bank.withdraw(customerId, accountId, BigDecimal.valueOf(500));
        String statement = bank.generateStatement(customerId, accountId);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = LocalDate.now().format(dateFormatter);

        Assertions.assertTrue(statement.contains("      date ||     credit ||      debit ||    balance"));
        Assertions.assertTrue(
                statement.contains(String.format("%s ||            ||     500.00 ||     500.00", date))
        );
        Assertions.assertTrue(
                statement.contains(String.format("%s ||    1000.00 ||            ||    1000.00", date))
        );
    }

    @Test
    public void testDepositingFunds() {
        Bank bank = new Bank();
        UUID customerId = bank.registerCustomer();
        UUID accountId = bank.openAccount(customerId, CurrentAccount.class);
        Account account = bank.getAccounts().get(accountId);
        account.deposit(BigDecimal.valueOf(1_000));
        Assertions.assertEquals(BigDecimal.valueOf(1_000), account.getBalance());
    }

    @Test
    public void testWithdrawingFunds() {
        Bank bank = new Bank();
        UUID customerId = bank.registerCustomer();
        UUID accountId = bank.openAccount(customerId, CurrentAccount.class);
        Account account = bank.getAccounts().get(accountId);
        account.deposit(BigDecimal.valueOf(1_000));
        account.withdraw(BigDecimal.valueOf(500));
        Assertions.assertEquals(BigDecimal.valueOf(500), account.getBalance());
    }
}
