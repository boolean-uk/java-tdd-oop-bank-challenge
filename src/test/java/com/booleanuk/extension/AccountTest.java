package com.booleanuk.extension;

import com.booleanuk.core.Bank;
import com.booleanuk.core.Branch;
import com.booleanuk.core.enums.AccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    Bank bank;
    Branch branch;

    @BeforeEach
    public void setupTests() {
        this.bank = new Bank();
        int branchNum = bank.createBranch();
        this.branch = bank.getBranchByNumber(branchNum);
    }

    @Test
    public void checkCalculateBalanceFromTransactions() {
        int accountNumber = bank.createAccount(branch, AccountType.SAVINGS); // Total: 0
        Assertions.assertEquals(0, branch.getAccountBalance(accountNumber));
        branch.performDeposit(accountNumber, 50); // Total: 50
        Assertions.assertEquals(50, branch.getAccountBalance(accountNumber));
        branch.performDeposit(accountNumber, 20.5); // Total: 70.5
        Assertions.assertEquals(70.5, branch.getAccountBalance(accountNumber));
        branch.performWithdrawal(accountNumber, 20); // Total: 50.5
        Assertions.assertEquals(50.5, branch.getAccountBalance(accountNumber));
        branch.performDeposit(accountNumber, 200.5); // Total: 251
        Assertions.assertEquals(251, branch.getAccountBalance(accountNumber));
        branch.performDeposit(accountNumber, 49.0); // Total: 300
        Assertions.assertEquals(300, branch.getAccountBalance(accountNumber));
        branch.performDeposit(accountNumber, 5); // Total: 305
        Assertions.assertEquals(305, branch.getAccountBalance(accountNumber));
        branch.performWithdrawal(accountNumber, 305); // Total: 305
        Assertions.assertEquals(0, branch.getAccountBalance(accountNumber));
    }
}
