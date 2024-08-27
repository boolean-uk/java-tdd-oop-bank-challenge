package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class BranchTest {
    @Test
    public void testIfBranchExist() {
        Branch osloBranch = new Branch("Oslo");
        Branch trondheimBranch = new Branch("Trondheim");
        Customer customer = new Customer("Melvin", "Seelan");
        CurrentAccount currentAccount = new CurrentAccount(500, osloBranch);
        SavingAccount savingAccount = new SavingAccount(1000, 2.5, trondheimBranch);
        customer.addAccount(currentAccount);
        customer.addAccount(savingAccount);
        Assertions.assertEquals(currentAccount.getBranch(),osloBranch);
    }


    @Test
    public void checkAccountIDInBranch() {
        Branch trondheimBranch = new Branch("Trondheim");
        Customer customer = new Customer("Melvin", "Seelan");
        SavingAccount savingAccount = new SavingAccount(1000, 2.5, trondheimBranch);
        SavingAccount savingAccount1 = new SavingAccount(1000, 2.5, trondheimBranch);
        customer.addAccount(savingAccount);
        customer.addAccount(savingAccount1);
        Assertions.assertNotNull(trondheimBranch.getAccounts());

    }

    @Test
    public void checkBranchName() {
        Branch newbranch = new Branch("Trondheim");
        Assertions.assertEquals("Trondheim", newbranch.getBranchName());

    }

}
