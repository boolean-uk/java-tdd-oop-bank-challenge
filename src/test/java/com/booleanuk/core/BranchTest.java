package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
