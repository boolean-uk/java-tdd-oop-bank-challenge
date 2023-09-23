package com.booleanuk.core.Users;

import com.booleanuk.core.Accounts.Account;
import com.booleanuk.core.Accounts.CurrentAccount;
import com.booleanuk.core.Accounts.SavingsAccount;
import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Enums.Branches;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    private Client client;
    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;
    private Branch branch;

    @BeforeEach
    public void setUp() {
        client = new Client("John Doe", "123-456-7890");
        currentAccount = new CurrentAccount(new BigDecimal("1000.00"), Branches.Sofia, client);
        savingsAccount = new SavingsAccount(new BigDecimal("1200.00"), Branches.Sofia, client);
//        branch = new Branch("Main Branch");
    }
    @Test
    public void testCustomerCanOpenCurrentAccount() {
        assertTrue(client.openCurrentAccount( currentAccount));
        assertEquals(currentAccount, client.getCurrentAccount());
    }

    @Test
    public void testCustomerCanOpenSavingsAccount() {
        assertTrue(client.openSavingsAccount( savingsAccount));
        assertEquals(savingsAccount, client.getSavingsAccount());
    }
    @Test
    public void testCustomerCannotRequestOverdraftForSavingsAccount() {
        client.openSavingsAccount(savingsAccount);
        assertFalse(client.requestOverdraft(savingsAccount, 1000.0));
    }
}
