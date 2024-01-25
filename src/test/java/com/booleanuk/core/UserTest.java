package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserTest {

    @Test
    public void createUser() {
        User user = new User(250799, "Marit");
        Assertions.assertEquals(250799, user.getUserId());
        Assertions.assertEquals("Marit", user.getName());
        Assertions.assertEquals(new ArrayList<>(), user.getAccounts());
    }

    @Test
    public void createAccount() {
        User user = new User(250799, "Marit");
        user.createAccount("Current");
        Assertions.assertEquals(1, user.getAccounts().size());
        Assertions.assertSame(user.getAccounts().get(0).getClass(), CurrentAccount.class);
        user.createAccount("Savings");
        Assertions.assertEquals(2, user.getAccounts().size());
        Assertions.assertSame(user.getAccounts().get(1).getClass(), SavingsAccount.class);
    }
}
