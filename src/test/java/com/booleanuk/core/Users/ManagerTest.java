package com.booleanuk.core.Users;

import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Enums.Status;
import com.booleanuk.core.Users.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTest {
    private Manager manager;
    private Branch branch;

    @BeforeEach
    public void setUp() {
        branch = new Branch(Branches.London, null);

        manager = new Manager("John Manager", "123-456-7890", branch);
    }

    @Test
    public void testReviewOverdraftRequestsApproved() {
        CurrentAccount currentAccount = new CurrentAccount(BigDecimal.valueOf(1000), branch.getBranchLocation(), null);

        currentAccount.requestOverdraft(BigDecimal.valueOf(500));

        manager.reviewOverdraftRequests();

        assertEquals(Status.Approved, currentAccount.getOverdraftStatus());
    }

    @Test
    public void testReviewOverdraftRequestsRejected() {
        CurrentAccount currentAccount = new CurrentAccount(BigDecimal.valueOf(1000), branch.getBranchLocation(), null);

        currentAccount.requestOverdraft(BigDecimal.valueOf(2000));

        manager.reviewOverdraftRequests();

        assertEquals(Status.Rejected, currentAccount.getOverdraftStatus());
    }
}