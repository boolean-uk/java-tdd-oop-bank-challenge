package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BranchTest {
    @Test
    public void testCreateUserInBranch()
    {
        Branch osloBranch = new Branch("Oslo_East", "Oslo");
        LocalDate birthday = LocalDate.of(1956, 3, 19);
        User user = new User("Large Nimpson", birthday);
        user.createCurrentAccount("Spending");
        user.getAccount("cu-78105109112115111110-1").assignBranch(osloBranch);
        osloBranch.addAccount("cu-78105109112115111110-1");

        Assertions.assertEquals("Oslo_East",
                user.getAccount("cu-78105109112115111110-1").getBranch());
        Assertions.assertTrue(osloBranch.getAccounts().contains("cu-78105109112115111110-1"));
    }
}
