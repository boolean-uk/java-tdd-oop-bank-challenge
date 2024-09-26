package com.booleanuk.core.Bank;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Accounts.SavingsAccount;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Users.Client;
import com.booleanuk.core.Users.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class BranchTest {

    private Branch branch;
    private Manager manager;

    @BeforeEach
    public void setUp() {
        manager = new Manager("John Manager", "123-456-7890", branch);

        branch = new Branch(Branches.Sofia, manager);
    }

    @Test
    public void testAddAccount() {
        SavingsAccount savingsAccount = new SavingsAccount(BigDecimal.valueOf(3000), branch, null);

        assertTrue(branch.addAccount(savingsAccount));

        assertTrue(branch.getAccounts().contains(savingsAccount));
    }

    @Test
    public void testGetSavingsAccounts() {
        SavingsAccount savingsAccount1 = new SavingsAccount(BigDecimal.valueOf(3000), branch, null);
        CurrentAccount currentAccount1 = new CurrentAccount(BigDecimal.valueOf(2000), branch, null);
        SavingsAccount savingsAccount2 = new SavingsAccount(BigDecimal.valueOf(4000), branch, null);

        branch.addAccount(savingsAccount1);
        branch.addAccount(currentAccount1);
        branch.addAccount(savingsAccount2);

        List<SavingsAccount> savingsAccounts = branch.getSavingsAccounts();

        assertEquals(2, savingsAccounts.size());

        assertTrue(savingsAccounts.contains(savingsAccount1));
        assertTrue(savingsAccounts.contains(savingsAccount2));

        assertFalse(savingsAccounts.contains(currentAccount1));
    }
    @Test
    public void testGetCurrentAccounts() {
        Client accountHolder = new Client("John Doe", "123-456-7890");

        SavingsAccount savingsAccount1 = new SavingsAccount(BigDecimal.valueOf(1500), branch, accountHolder);
        CurrentAccount currentAccount1 = new CurrentAccount(BigDecimal.valueOf(2000), branch, accountHolder);
        CurrentAccount currentAccount2 = new CurrentAccount(BigDecimal.valueOf(1500), branch, accountHolder);

        branch.addAccount(savingsAccount1);
        branch.addAccount(currentAccount1);
        branch.addAccount(currentAccount2);

        List<CurrentAccount> currentAccounts = branch.getCurrentAccounts();

        assertEquals(2, currentAccounts.size());

        assertTrue(currentAccounts.contains(currentAccount1));
        assertTrue(currentAccounts.contains(currentAccount2));

        assertFalse(currentAccounts.contains(savingsAccount1));
    }
}
