package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {

    private Bank bank;
    private String bankName;
    private String branchName;
    @BeforeEach
    public void setup(){
        bankName = "Alpha Bank";
        branchName = "Alpha Athens";
        bank = new Bank(bankName);

    }

    @Test
    public void shouldCreateBranchIfNotExists(){
        Assertions.assertNotNull(bank.createBranch(branchName));
        Assertions.assertEquals(branchName, bank.getBranches().get(branchName).getName());
    }

    @Test
    public void shouldNotCreateBranchIfExists(){
        bank.createBranch(branchName);
        Assertions.assertNull(bank.createBranch(branchName));
    }
}