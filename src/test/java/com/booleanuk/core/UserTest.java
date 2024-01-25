package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testCreateUser(){
        User user = new User("John", "John@example.org");
        Assertions.assertEquals("John", user.getName());
        Assertions.assertEquals("John@example.org", user.getEmail());
        Assertions.assertNull(user.getCurrentAccount());
        Assertions.assertNull(user.getSavingsAccount());
    }
}
