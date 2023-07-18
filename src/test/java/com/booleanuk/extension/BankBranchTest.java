package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

import static com.booleanuk.extension.Request.Status.ACCEPTED;
import static com.booleanuk.extension.Request.Status.PENDING;

public class BankBranchTest {

    @BeforeEach
    public void setup() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @Test
    public void testOperatingThroughBank() {
        BankBranch bankBranch = (new BankHQ()).openBranch();
        UUID customerId = bankBranch.registerCustomer();
        UUID accountId = bankBranch.openAccount(customerId, CurrentAccount.class);
        bankBranch.deposit(accountId, BigDecimal.valueOf(1_000));
        bankBranch.withdraw(customerId, accountId, BigDecimal.valueOf(500));
        String statement = bankBranch.generateStatement(customerId, accountId);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = LocalDate.now().format(dateFormatter);

        Assertions.assertTrue(statement.contains("      date ||     credit ||      debit ||    balance"));
        Assertions.assertTrue(statement.contains(String.format("%s ||            ||     500.00 ||     500.00", date)));
        Assertions.assertTrue(statement.contains(String.format("%s ||    1000.00 ||            ||    1000.00", date)));
    }

    @Test
    public void testDepositingFunds() {
        BankBranch bankBranch = (new BankHQ()).openBranch();
        UUID customerId = bankBranch.registerCustomer();
        UUID accountId = bankBranch.openAccount(customerId, CurrentAccount.class);
        Account account = bankBranch.getAccounts().get(accountId);
        account.deposit(BigDecimal.valueOf(1_000));
        Assertions.assertEquals(BigDecimal.valueOf(1_000), account.getBalance());
    }

    @Test
    public void testWithdrawingFunds() {
        BankBranch bankBranch = (new BankHQ()).openBranch();
        UUID customerId = bankBranch.registerCustomer();
        UUID accountId = bankBranch.openAccount(customerId, CurrentAccount.class);
        bankBranch.deposit(accountId, BigDecimal.valueOf(1_000));
        bankBranch.withdraw(customerId, accountId, BigDecimal.valueOf(500));

        Account account = bankBranch.getAccounts().get(accountId);
        Assertions.assertEquals(BigDecimal.valueOf(500), account.getBalance());
    }

    @Test
    public void testRequestingOverdraftProcedure() {
        BankBranch bankBranch = (new BankHQ()).openBranch();
        UUID customerId = bankBranch.registerCustomer();
        UUID accountId = bankBranch.openAccount(customerId, CurrentAccount.class);

        Assertions.assertFalse(bankBranch.withdraw(customerId, accountId, BigDecimal.valueOf(500)));

        bankBranch.requestOverDraft(customerId, accountId, BigDecimal.valueOf(500));
        Request request = bankBranch.getRequests(customerId).get(0);

        Assertions.assertEquals(PENDING, request.getStatus());
        Assertions.assertFalse(bankBranch.withdraw(customerId, accountId, BigDecimal.valueOf(500)));


        bankBranch.reviewOverdraftRequest(request, ACCEPTED);
        Assertions.assertEquals(ACCEPTED, request.getStatus());

        Assertions.assertTrue(bankBranch.withdraw(customerId, accountId, BigDecimal.valueOf(500)));
    }

}