package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    Bank bank;
    Branch companyBranch;
    Branch individualBranch;

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

}

