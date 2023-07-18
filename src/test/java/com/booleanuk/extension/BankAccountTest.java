package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    @Test
    public void getBranchTest() {
        Branch branch = new Branch("PLWarsaw", "Poland, Warsaw");
        BankAccount account = new BankAccount(1000.0, branch);
        Assertions.assertEquals(branch, account.getBranch());
    }
    @Test
    public void balanceGetterTest() {
        CurrentAccount account = new CurrentAccount(1000.0);
        account.withdraw(100.0);
        account.deposit(75.77);
        Assertions.assertEquals(975.77, account.getBalance());
        account.withdraw(1000.0);
        Assertions.assertEquals(975.77, account.getBalance());

        SavingsAccount account2 = new SavingsAccount(1000.0);
        account2.withdraw(100.0);
        account2.deposit(75.77);
        Assertions.assertEquals(970.77, account2.getBalance());
    }
}
