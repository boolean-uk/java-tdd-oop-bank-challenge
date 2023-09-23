package com.booleanuk.core.Accounts;
import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Enums.Status;
import com.booleanuk.core.Users.Client;
import com.booleanuk.core.Users.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
public class CurrentAccountTest {
    private CurrentAccount currentAccount;
    private Branch branch;
    private Manager manager;

    @BeforeEach
    public void setUp() {
        Client accountHolder = new Client("John Doe", "123-456-7890");
        manager = new Manager("John Manager", "123-456-7890", branch);

        branch = new Branch(Branches.Sofia, manager);
        currentAccount = new CurrentAccount(BigDecimal.valueOf(2000), branch, accountHolder);
    }

    @Test
    public void testRequestOverdraftApproved() {
        assertTrue(currentAccount.requestOverdraft(BigDecimal.valueOf(1000)));

        assertEquals(Status.Pending, currentAccount.getOverdraftStatus());
    }

    @Test
    public void testRequestOverdraftRejected() {
        assertThrows(IllegalArgumentException.class, () -> currentAccount.requestOverdraft(BigDecimal.ZERO));

        assertNull(currentAccount.getOverdraftStatus());
    }

    @Test
    public void testRequestOverdraftResetAfterRejection() {
        assertTrue(currentAccount.requestOverdraft(BigDecimal.valueOf(1000)));

        currentAccount.setOverdraftStatus(Status.Rejected);

        assertTrue(currentAccount.requestOverdraft(BigDecimal.valueOf(500)));

        assertEquals(Status.Pending, currentAccount.getOverdraftStatus());
    }

    @Test
    public void testRequestOverdraftNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> currentAccount.requestOverdraft(BigDecimal.valueOf(-500)));

        assertNull(currentAccount.getOverdraftStatus());
    }

    @Test
    public void testRequestOverdraftRejectedStatus() {
        currentAccount.setOverdraftStatus(Status.Rejected);

        assertTrue(currentAccount.requestOverdraft(BigDecimal.valueOf(500)));

        assertEquals(Status.Pending, currentAccount.getOverdraftStatus());
    }
}
