package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BranchTest {

    @Test
    public void addAccountToBranch(){
        Branch branch = new Branch("Gothenburg");
        BankAccount currentAccount = new CurrentAccountTest(branch);

        Assertions.assertTrue( branch.addAccount(currentAccount));
    }
}
