package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBank {

    @Test
    public void testBankSystem(){
        Bank bank = new Bank();
        bank.createBranch();
        bank.createBranch();

        bank.getBranchByID(1000).createCurrentAccount();
        bank.getBranchByID(1000).createCurrentAccount();
        bank.getBranchByID(1001).createCurrentAccount();
        bank.getBranchByID(1001).createCurrentAccount();

        bank.getBranchByID(1000).getAccounts().get(100000).deposit(1000.00f);
        bank.getBranchByID(1000).getAccounts().get(100000).withdraw(500.00f);
        bank.getBranchByID(1000).getAccounts().get(100001).deposit(500.00f);
        bank.getBranchByID(1000).getAccounts().get(100001).withdraw(250.00f);
        bank.getBranchByID(1001).getAccounts().get(100000).deposit(2000.00f);
        bank.getBranchByID(1001).getAccounts().get(100000).withdraw(1000.00f);
        bank.getBranchByID(1001).getAccounts().get(100001).deposit(3000.00f);
        bank.getBranchByID(1001).getAccounts().get(100001).withdraw(5000.00f);


        Assertions.assertEquals(500.00f, bank.getBranchByID(1000).getAccounts().get(100000).calculateBalance());
        Assertions.assertEquals(250.00f, bank.getBranchByID(1000).getAccounts().get(100001).calculateBalance());
        Assertions.assertEquals(1000.00f, bank.getBranchByID(1001).getAccounts().get(100000).calculateBalance());
        Assertions.assertEquals(3000.00f, bank.getBranchByID(1001).getAccounts().get(100001).calculateBalance());


    }
}
