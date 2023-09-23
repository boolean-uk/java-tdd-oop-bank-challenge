package com.booleanuk.core.Accounts;
import com.booleanuk.core.Accounts.SavingsAccount;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
public class SavingsAccountTest {
    private SavingsAccount savingsAccount;

    @BeforeEach
    public void setUp() {
        User user = new User("John Doe", "123-456-7890");
        Branches branch = Branches.Sofia;

        BigDecimal initialBalance = BigDecimal.valueOf(2000);
        savingsAccount = new SavingsAccount(initialBalance, branch, user);
    }

    @Test
    public void testInitializationWithMinimumBalance() {
        assertNotNull(savingsAccount);
    }

    @Test
    public void testInitializationWithInsufficientBalance() {
        BigDecimal invalidBalance = BigDecimal.valueOf(1000);
        assertThrows(IllegalArgumentException.class, () -> {
            new SavingsAccount(invalidBalance, Branches.Sofia, new User("Jane Doe", "987-654-3210"));
        });
    }

    @Test
    public void testDepositFunds() {
        BigDecimal depositAmount = BigDecimal.valueOf(500);
        savingsAccount.depositFunds(depositAmount);

        assertEquals(BigDecimal.valueOf(2500), savingsAccount.getBalance());
    }

    @Test
    public void testWithdrawFunds() {
        BigDecimal depositAmount = BigDecimal.valueOf(1000);
        savingsAccount.depositFunds(depositAmount);


        BigDecimal withdrawAmount = BigDecimal.valueOf(500);
        savingsAccount.withdrawFunds(withdrawAmount);

        assertEquals(BigDecimal.valueOf(2500), savingsAccount.getBalance());
    }

    @Test
    public void testWithdrawFundsInsufficientBalance() {
        BigDecimal withdrawAmount = BigDecimal.valueOf(2500);
        assertThrows(IllegalArgumentException.class, () -> {
            savingsAccount.withdrawFunds(withdrawAmount);
        });
    }

    @Test
    public void testRequestOverdraft() {
        BigDecimal overdraftAmount = BigDecimal.valueOf(1000);
        assertFalse(savingsAccount.requestOverdraft(overdraftAmount));
    }
}
