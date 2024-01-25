package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
    @Test
    public void createAccount() {
        User user = new User(123456, "UsersName");
        CurrentAccount a = new CurrentAccount(user);
        Assertions.assertEquals(user, a.getOwner());
        Assertions.assertEquals(0, a.getTransactions().size());
        Assertions.assertEquals(0.00, a.getBalance());
    }
}
