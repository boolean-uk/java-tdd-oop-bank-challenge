package com.booleanuk.core.Accounts;
import com.booleanuk.core.Accounts.SavingsAccount;
import com.booleanuk.core.Bank.Branch;
import com.booleanuk.core.Enums.Branches;
import com.booleanuk.core.Users.Manager;
import com.booleanuk.core.Users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
public class SavingsAccountTest {
    private SavingsAccount savingsAccount;
    private Branch branch;
    private Manager manager;

    @BeforeEach
    public void setUp() {
        User user = new User("John Doe", "123-456-7890");
        manager = new Manager("John Manager", "123-456-7890", branch);
        branch = new Branch(Branches.Sofia, manager);
        BigDecimal initialBalance = BigDecimal.valueOf(2000);
        savingsAccount = new SavingsAccount(initialBalance, branch, user);
    }

    @Test
    public void testInitializationWithMinimumBalance() {
        assertNotNull(savingsAccount);
        assertEquals(BigDecimal.valueOf(2000),savingsAccount.getBalance());
    }

    @Test
    public void testInitializationWithInsufficientBalance() {
        BigDecimal invalidBalance = BigDecimal.valueOf(1000);
        assertThrows(IllegalArgumentException.class, () -> {
            new SavingsAccount(invalidBalance, branch, new User("Jane Doe", "987-654-3210"));
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
        BigDecimal actualBalance = savingsAccount.getBalance();
        assertEquals(BigDecimal.valueOf(2000),actualBalance);

        BigDecimal depositAmount = BigDecimal.valueOf(1000);
        savingsAccount.depositFunds(depositAmount);

        actualBalance = savingsAccount.getBalance();
        assertEquals(BigDecimal.valueOf(3000),actualBalance);

        BigDecimal withdrawAmount = BigDecimal.valueOf(500);
        savingsAccount.withdrawFunds(withdrawAmount);

        actualBalance = savingsAccount.getBalance();
        assertEquals(BigDecimal.valueOf(2500), actualBalance);
//        BigDecimal invalidWithdrawAmount = BigDecimal.valueOf(500);
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
