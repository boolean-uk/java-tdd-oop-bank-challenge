package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    Bank bank;
    Branch companyBranch;
    Branch individualBranch;
    Costumer individual = new Individual("Individual");
    Costumer Company = new Company("Company");

    MainTest() {
        this.bank = new Bank();
        this.companyBranch = new Branch("Company");
        this.individualBranch = new Branch("individualBranch");

    }

    @Test
    public void testAddBranch() {
        bank.addBranch(companyBranch);
        bank.addBranch(individualBranch);
        Assertions.assertEquals(2, bank.getSizeOfBranch());
    }

    @Test
    public void testAddAccountToBranch() {
        int deposit = 500;
        companyBranch.createSavingsAccount(Company,deposit);
        Assertions.assertEquals(1, companyBranch.getAccountsForBranch().size());
        individualBranch.createSavingsAccount(individual,deposit);
        Assertions.assertEquals(1, individualBranch.getAccountsForBranch().size());
    }

    @Test
    public void testAddAccountToCostumer() {
        int deposit = 500;
        companyBranch.createSavingsAccount(Company, deposit);
        Assertions.assertEquals(1, Company.getAccountsForCostumer().size());
        individualBranch.createSavingsAccount(individual, deposit);
        Assertions.assertEquals(1, individual.getAccountsForCostumer().size());
    }
}

