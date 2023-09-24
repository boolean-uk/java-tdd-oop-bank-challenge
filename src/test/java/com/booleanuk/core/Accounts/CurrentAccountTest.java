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
    public void testRequestOverdraft() {
        assertTrue(currentAccount.requestOverdraft(BigDecimal.valueOf(1000)));
        assertEquals(Status.Pending, currentAccount.getOverdraftRequest().getStatus());
    }

    @Test
    public void testRequestOverdraftUnsuccessful() {
        assertThrows(IllegalArgumentException.class, () -> currentAccount.requestOverdraft(BigDecimal.ZERO));
    }

    @Test
    public void testRequestOverdraftResetAfterRejection() {
        assertTrue(currentAccount.requestOverdraft(BigDecimal.valueOf(1000)));
        currentAccount.getOverdraftRequest().setStatus(Status.Rejected);
        assertTrue(currentAccount.requestOverdraft(BigDecimal.valueOf(500)));
        assertEquals(Status.Pending, currentAccount.getOverdraftRequest().getStatus());
    }

    @Test
    public void testRequestOverdraftNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> currentAccount.requestOverdraft(BigDecimal.valueOf(-500)));
    }
}
