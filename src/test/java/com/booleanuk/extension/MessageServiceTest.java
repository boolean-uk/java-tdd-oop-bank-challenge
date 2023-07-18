package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

public class MessageServiceTest {
    @Test
    public void testSendingStatementToCustomer() {
        String phoneNumber = System.getenv("MY_PHONE_NUMBER");
        BankBranch bankBranch = (new BankHQ()).openBranch();
        UUID customerId = bankBranch.registerCustomer(phoneNumber);
        UUID accountId = bankBranch.openAccount(customerId, CurrentAccount.class);
        bankBranch.deposit(accountId, BigDecimal.valueOf(1_000));
        bankBranch.deposit(accountId, BigDecimal.valueOf(2_000));
        bankBranch.withdraw(customerId, accountId, BigDecimal.valueOf(1500));
        bankBranch.withdraw(customerId, accountId, BigDecimal.valueOf(1500));
        bankBranch.deposit(accountId, BigDecimal.valueOf(2_000));
        bankBranch.withdraw(customerId, accountId, BigDecimal.valueOf(500));
        bankBranch.deposit(accountId, BigDecimal.valueOf(2_000));
        String statement = bankBranch.generateStatement(customerId, accountId);

        Customer customer = bankBranch.getCustomers().get(customerId);
//        Assertions.assertEquals("queued", MessageService.send(statement, customer));
    }
}
