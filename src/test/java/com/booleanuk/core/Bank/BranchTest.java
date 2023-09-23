package com.booleanuk.core.Bank;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Accounts.SavingsAccount;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Users.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BranchTest {

    private Client client;
    private Account currentAccount;
    private Account savingsAccount;
    private Branch branch;

    @BeforeEach
    public void setUp() {
        client = new Client("John Doe", "123-456-7890");
        currentAccount = new CurrentAccount(BigDecimal.ZERO, Branches.Sofia, client);
        savingsAccount = new SavingsAccount(BigDecimal.ZERO, Branches.Sofia, client);
        branch = new Branch(Branches.Sofia);
    }


    @Test
    public void testBranchCreation() {
        assertNotNull(branch);
    }

    @Test
    public void testAssociatingAccountWithBranch() {
        branch.associateAccount(currentAccount);
        assertTrue(branch.getAccounts().contains(currentAccount));
    }

}
