package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BranchTest {
    @Test
    public void testCreateUserInBranch()
    {
        Bank bank = new Bank();
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createCurrentAccount("Spending", bank);

        Assertions.assertEquals("Oslo_East",
                user.getAccount("cu-78105109112115111110-1").getBranch().getName());
        Assertions.assertTrue(bank.getBranch("Oslo_East").getAccounts().contains("cu-78105109112115111110-1"));
    }
    @Test
    public void testChangeBranch()
    {
        Bank bank = new Bank();
        LocalDate birthday = LocalDate.of(1956, 3, 19);

        User user = new User("Large Nimpson", birthday);
        user.createCurrentAccount("Spending", bank);
        user.getAccount("cu-78105109112115111110-1").assignBranch(bank.getBranch("Trondheim_Central"));

        Assertions.assertEquals("Trondheim_Central",
                user.getAccount("cu-78105109112115111110-1").getBranch().getName());
        Assertions.assertTrue(bank.getBranch("Trondheim_Central")
                .getAccounts()
                .contains("cu-78105109112115111110-1"));
    }

    @Test
    public void testCantAddUserToBranchTwiceOrMore()
    {
        Bank bank = new Bank();
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createCurrentAccount("Spending", bank);
        user.getAccount("cu-78105109112115111110-1").assignBranch(bank.getBranch("Oslo_East"));

        Assertions.assertFalse(bank.getBranch("Oslo_East").addAccount("cu-78105109112115111110-1"));
    }
}
