package com.booleanuk.core;

import com.booleanuk.core.enums.AccountType;
import com.booleanuk.core.models.accounts.Account;
import com.booleanuk.core.models.accounts.CurrentAccount;
import com.booleanuk.core.models.accounts.SavingsAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BranchTest {
    Bank bank;
    Branch branch;

    @BeforeEach
    public void setupTests() {
        this.bank = new Bank();
        int branchNum = bank.createBranch();
        this.branch = bank.getBranchByNumber(branchNum);
    }

    @Test
    public void canCreateNewCurrentAccount() {
        Assertions.assertEquals(0, branch.getAccounts().size());
        bank.createAccount(branch, AccountType.CURRENT);
        Assertions.assertEquals(1, branch.getAccounts().size());
        Assertions.assertInstanceOf(CurrentAccount.class, branch.getAccounts().get(0));
    }

    @Test
    public void canCreateNewSavingsAccount() {
        bank.createAccount(branch, AccountType.SAVINGS);
        Assertions.assertInstanceOf(SavingsAccount.class, branch.getAccounts().get(0));
    }

    @Test
    public void canGetAccountByAccountNumber() {
        int accountNumber = bank.createAccount(branch, AccountType.CURRENT);
        Account account = branch.getAccountByAccountNumber(accountNumber);
        Assertions.assertInstanceOf(CurrentAccount.class, account);
        Assertions.assertEquals(accountNumber, account.getAccountNumber());

        int imaginaryAccountNumber = 1234567;
        Assertions.assertNull(branch.getAccountByAccountNumber(imaginaryAccountNumber));
    }

    @Test
    public void canDepositMoneyIntoAccount() {
        int accountNumber = bank.createAccount(branch, AccountType.SAVINGS);
        Assertions.assertEquals(5.0, branch.performDeposit(accountNumber, 5));
        Assertions.assertEquals(5.0, branch.getAccountByAccountNumber(accountNumber).getBalanceInBaseUnits());
        Assertions.assertEquals(8.7, branch.performDeposit(accountNumber, 3.7));
    }

    @Test
    public void canWithdrawMoneyFromAccount() {
        int accountNumber = bank.createAccount(branch, AccountType.CURRENT);
        branch.performDeposit(accountNumber, 17.3);
        Assertions.assertEquals(12.3, branch.performWithdrawal(accountNumber, 5));
        Assertions.assertEquals(12.3, branch.getAccountByAccountNumber(accountNumber).getBalanceInBaseUnits());
    }

    @Test
    public void cantWithdrawNonExistentMoney() {
        int accountNumber = bank.createAccount(branch, AccountType.SAVINGS);
        branch.performDeposit(accountNumber, 17.3);
        Assertions.assertEquals(17.3, branch.performWithdrawal(accountNumber, 25));
        // Should also print that the transaction failed
    }

    @Test
    public void canOverdraftCurrentAccount() {
        int accountNumber = bank.createAccount(branch, AccountType.CURRENT);
        Assertions.assertEquals(-25, branch.performWithdrawal(accountNumber, 25));
        Assertions.assertEquals(-1000, branch.performWithdrawal(accountNumber, 975));
        Assertions.assertNotEquals(-1001, branch.performWithdrawal(accountNumber, 1));
    }
}
