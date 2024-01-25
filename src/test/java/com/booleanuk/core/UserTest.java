package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserTest {

    @Test
    public void createUser() {
        User user = new User(int userId, String name);
        Assertions.assertEquals(userId, user.getUserId());
        Assertions.assertEquals(name, user.getName);
        Assertions.assertEquals(new ArrayList<>(), user.getAccounts);
    }
}
