package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void createUserAndCurrentAccount(){
        User user = new User("John", "John@example.org");
        CurrentAccount currentAccount = new currentAccount(user);
        Assertions.assertEquals(user.getCurrentAccount(), 0.00);
    }
}
