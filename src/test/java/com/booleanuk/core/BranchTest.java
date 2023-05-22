package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BranchTest {

    private String bankName;
    private String branchName;
    private Bank bank;
    private Branch branch;
    @BeforeEach
    public void setup(){
        bankName = "AlphaBank";
        branchName = "Alpha Athens";
        bank = new Bank(bankName);
        branch = bank.createBranch(branchName);
    }

    @Test
    public void shouldCreateAndAddCustomer(){
        String customerId = branch.createCustomer();

        Assertions.assertFalse(branch.getCustomers().isEmpty());
        Assertions.assertEquals(customerId, branch.getCustomers().get(customerId).getId());
    }

    @Test
    public void shouldCreateAccountForCustomer(){
        String customerId = branch.createCustomer();
        String accountId = branch.createAccount(customerId, Bank.AccountType.CURRENT, 2000.0);
        Customer customer = branch.getCustomers().get(customerId);

        Assertions.assertEquals(BigDecimal.valueOf(2000d), customer.getAccounts().get(accountId).getBalance());
    }

    @Test
    public void shouldNotCreateAccountIfAlreadyExists(){
        String customerId = branch.createCustomer();
        String accountId = branch.createAccount(customerId, Bank.AccountType.CURRENT, 2000.0);

        Assertions.assertEquals(ErrorType.ACCOUNT_EXISTS, accountId);
    }
}
