package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankManagerTest {

    Bank bank;
    Branch branch;
    String accountId;
    String customerId;
    @BeforeEach
    public void setup(){
        bank = new Bank("National Bank");
        branch = bank.createBranch("National Bank Peristeri");

        customerId = branch.createCustomer();
        accountId = branch.createAccount(customerId, Bank.AccountType.CURRENT, 10000);

        branch.getCustomers().get(customerId).getAccounts().get(accountId).requestOverdraft(40000);
    }

    @Test
    public void shouldUpdateRequestStatusToAccepted(){
        BankManager.evaluateOverdraftRequest(branch.getCustomers().get(customerId).getAccounts().get(accountId).getOverdraftRequest(), Bank.OverdraftStatus.ACCEPTED);

        Assertions.assertEquals(Bank.OverdraftStatus.ACCEPTED, branch.getCustomers().get(customerId).getAccounts().get(accountId).getOverdraftRequest().getStatus());
    }
}
