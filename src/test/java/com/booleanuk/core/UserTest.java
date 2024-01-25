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
}
